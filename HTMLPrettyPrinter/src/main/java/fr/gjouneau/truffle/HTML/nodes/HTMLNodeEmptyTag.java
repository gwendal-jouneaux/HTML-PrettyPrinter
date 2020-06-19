package fr.gjouneau.truffle.HTML.nodes;

import java.util.List;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags;

public class HTMLNodeEmptyTag extends HTMLNodeBaseTag {

	public HTMLNodeEmptyTag(Class<? extends Tag> tag, List<HTMLNodeAttribute> attributes, int sourceStart, int sourceEnd) {
		super(tag, attributes,sourceStart, sourceEnd);
	}
	
	public boolean hasTag(Class<? extends Tag> tag) {
		if(tag == HTMLInstrumentationTags.VoidElement.class) return true;
		if(tag == this.tag) return true;
        return super.hasTag(tag);
    }

	@Override
	public String execute(VirtualFrame frame) {
		String out = "<"+tag.getSimpleName().toLowerCase();
		for (int i = 0; i < attributes.length; i++) {
			out += " "+attributes[i].execute(frame);
		}
		out += "/>";
		return out;
	}

}
