package fr.gjouneau.truffle.HTML.nodes;

import java.util.List;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.Tag;

public abstract class HTMLNodeBaseTag extends HTMLNodeBase{

	@CompilationFinal protected final Class<? extends Tag> tag;
	@Children protected HTMLNodeAttribute[] attributes;
	
	public HTMLNodeBaseTag(Class<? extends Tag> tag, List<HTMLNodeAttribute> attributes, int sourceStart, int sourceEnd) {
		super(sourceStart, sourceEnd);
		this.tag = tag;
		this.attributes = new HTMLNodeAttribute[attributes.size()];
		for (int i = 0; i < this.attributes.length; i++) {
			this.attributes[i] = attributes.get(i);
		}
	}

	public Class<? extends Tag> getTag() {
		return tag;
	}

	public HTMLNodeAttribute[] getAttributes() {
		return attributes;
	}
}
