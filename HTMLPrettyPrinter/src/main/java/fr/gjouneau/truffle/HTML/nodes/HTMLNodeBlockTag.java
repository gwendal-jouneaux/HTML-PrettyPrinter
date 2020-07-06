package fr.gjouneau.truffle.HTML.nodes;

import java.util.List;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags;

public class HTMLNodeBlockTag extends HTMLNodeBaseTag {
	
	@Children private HTMLNodeBase[] children;

	public HTMLNodeBlockTag(Class<? extends Tag> tag, List<HTMLNodeAttribute> attributes, List<HTMLNodeBase> children, int sourceStart, int sourceEnd) {
		super(tag, attributes,sourceStart, sourceEnd);
		this.children = new HTMLNodeBase[children.size()];
		for (int i = 0; i < this.children.length; i++) {
			this.children[i] = children.get(i);
		}
	}
	
	public HTMLNodeBlockTag(String tag, List<HTMLNodeAttribute> attributes, List<HTMLNodeBase> children, int sourceStart, int sourceEnd) {
		super(tag, attributes,sourceStart, sourceEnd);
		this.children = new HTMLNodeBase[children.size()];
		for (int i = 0; i < this.children.length; i++) {
			this.children[i] = children.get(i);
		}
	}
	
	public boolean hasTag(Class<? extends Tag> tag) {
		if(tag == HTMLInstrumentationTags.BlockElement.class) return true;
		if(tag == this.tag) return true;
        return super.hasTag(tag);
    }

	@Override
	public String execute(VirtualFrame frame) {
		String out = "<"+stringTag;
		for (int i = 0; i < attributes.length; i++) {
			out += " "+attributes[i].execute(frame);
		}
		out += ">";
		for (HTMLNodeBase child : children) {
			if(child != null) out += child.execute(frame);
		}
		out += "</"+stringTag + ">";
		return out;
	}

	public HTMLNodeBase[] children() {
		return children;
	}

	
}
