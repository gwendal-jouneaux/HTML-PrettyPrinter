package fr.gjouneau.truffle.HTML.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.instrumentation.Tag;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodeAttribute;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodeBase;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodeBaseTag;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodeBlockTag;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodeEmptyTag;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodePlainText;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodeRoot;

public class HTMLParser {
	
	private final String content;
	private int index;
	private final Map<String,Class<? extends Tag>> mapping;
	private final List<Character> WS = Arrays.asList(' ','\r','\n','\t');
	
	public HTMLParser(String fileContent) {
		this.content = fileContent;
		this.mapping = HTMLInstrumentationTags.getMapping();
	}
	
	public HTMLNodeRoot parse(TruffleLanguage<?> language) {
		index = content.indexOf("<html");
		HTMLNodeBlockTag htmlBlock = (HTMLNodeBlockTag) parseNext(content.length());
		//Truffle.getRuntime().createCallTarget(rootNode)
		return new HTMLNodeRoot(language, htmlBlock);
	}
	
	private HTMLNodeBase parseNext(int endIndex) {
		int tempI = index;
		do {
			while(WS.contains(content.charAt(tempI)) && tempI < endIndex) {
				tempI++;
			}
		}while((isEndTag() || (isComment(tempI) && 0<(tempI=bypassComment(tempI)))) && tempI < endIndex);
		if(tempI >= endIndex) {
			index = endIndex;
			return null;
		}
		
		if(content.charAt(tempI) == '<') {
			index = tempI+1;
			return parseTag(endIndex);
		} else {
			return parseText(endIndex);
		}
	}
	
	private HTMLNodeBaseTag parseTag(int endIndex) {
		int sourceSectionStart = index;
		String stringTag = "";
		while(!WS.contains(content.charAt(index)) && content.charAt(index) != '>') {
			stringTag += content.charAt(index);
			index++;
		}
		Class<? extends Tag> tag = mapping.get(stringTag.toUpperCase());
		
		if (Arrays.asList(HTMLInstrumentationTags.VOID_ELEMENT).contains(tag)) {
			return parseEmpty(sourceSectionStart, endIndex, tag);
		} else {
			return parseBlock(sourceSectionStart, endIndex, tag);
		}
	}
	
	private HTMLNodeBlockTag parseBlock(int startindex, int endIndex, Class<? extends Tag> tag) {
		int tagEnd = findIndexOf('>',index,endIndex);
		HTMLNodeAttribute attr;
		List<HTMLNodeAttribute> attributes = new ArrayList<HTMLNodeAttribute>();
		while((attr = parseAttribute(tagEnd)) != null) {
			attributes.add(attr);
		}
		int blockEnd = findEndTagIndex(tag, index, endIndex);
		List<HTMLNodeBase> children = new ArrayList<HTMLNodeBase>();
		while(index < endIndex) {
			HTMLNodeBase elem = parseNext(blockEnd);
			if(elem != null) {
				children.add(elem);
			} else {
				break;
			}
		}
		if(index < endIndex) {
			index = Math.min(endIndex, index +tag.getSimpleName().length()+3);
		}
		return new HTMLNodeBlockTag(tag, attributes, children, startindex, findIndexOf('>',blockEnd,endIndex));
	}
	
	private HTMLNodeEmptyTag parseEmpty(int startindex, int endIndex, Class<? extends Tag> tag) {
		int tagEnd = findIndexOf('>',index,endIndex);
		int padding = (content.charAt(tagEnd-1)=='/')?1:0;
		HTMLNodeAttribute attr;
		List<HTMLNodeAttribute> attributes = new ArrayList<HTMLNodeAttribute>();
		while((attr = parseAttribute(tagEnd-padding)) != null) {
			attributes.add(attr);
		}
		index += padding;
		return new HTMLNodeEmptyTag(tag, attributes, startindex, tagEnd+padding);
	}
	
	private HTMLNodePlainText parseText(int endIndex) {
		int sourceSectionStart = index;
		StringBuilder out = new StringBuilder();
		do {
			while(content.charAt(index) != '<') {
				out.append(content.charAt(index));
				index++;
			}
		}while(isComment() && bypassComment());
		return new HTMLNodePlainText(out.toString(), sourceSectionStart, index-1);
	}	
	
	private HTMLNodeAttribute parseAttribute(int endIndex) {
		while(WS.contains(content.charAt(index))) {
			index++;
		}
		if(index >= endIndex) {
			index++;
			return null;
		}
		int sourceSectionStart = index;
		String name = "";
		while(!WS.contains(content.charAt(index)) && content.charAt(index)!='=' && index < endIndex) {
			name += content.charAt(index);
			index++;
		}
		if(content.charAt(index)=='=') {
			index++;
			HTMLNodeAttribute.attributeType type;
			char endChar = ' ';
			switch (content.charAt(index)) {
			case '"':
				type = HTMLNodeAttribute.attributeType.DOUBLE_QUOTED;
				index++;
				endChar = '"';
				break;
			case '\'':
				type = HTMLNodeAttribute.attributeType.SIMPLE_QUOTED;
				index++;
				endChar = '\'';
				break;
			default:
				type = HTMLNodeAttribute.attributeType.UNQUOTED;
				break;
			}
			String value = "";
			while(content.charAt(index) != endChar  && index < endIndex) {
				value += content.charAt(index);
				index++;
			}
			if(index < endIndex && type!=HTMLNodeAttribute.attributeType.UNQUOTED) {
				index++;
			}
			return new HTMLNodeAttribute(name, value, type, sourceSectionStart, index-1);
		}
		return new HTMLNodeAttribute(name, null, null, sourceSectionStart, index-1);
	}
	
	private int findEndTagIndex(Class<? extends Tag> tag, int startIndex, int endIndex) {
		int count = 1;
		startIndex = content.indexOf('<', startIndex)+1;
		while(startIndex < endIndex) {
			int sign = 1;
			if(content.charAt(startIndex)=='/') {
				sign = -1;
				startIndex++;
			}
			String stringTag = "";
			while(!WS.contains(content.charAt(startIndex)) && content.charAt(startIndex) != '>') {
				stringTag += content.charAt(startIndex);
				startIndex++;
			}
			Class<? extends Tag> actualTag = mapping.get(stringTag.toUpperCase());
			if(actualTag == tag) {
				count += sign;
			}
			if(count <= 0) {
				return startIndex - stringTag.length() -2;
			}
			startIndex = content.indexOf('<', startIndex)+1;
		}
		
		return endIndex;
	}
	
	private int findIndexOf(char c, int startIndex, int endIndex) {
		int i = content.indexOf(c, startIndex);
		return endIndex<=i?-1:i;
	}
	
	private boolean isComment(int index) {
		return content.startsWith("<!--", index);
	}
	
	private boolean isComment() {
		return isComment(index);
	}
	
	private int bypassComment(int index) {
		int out = content.indexOf("-->", index);
		if(out == -1) return content.length();
		return out+3;
	}
	
	private boolean bypassComment() {
		index = content.indexOf("-->", index)+3;
		return true;
	}
	
	private boolean isEndTag() {
		return content.startsWith("</", index);
	}
	
}
