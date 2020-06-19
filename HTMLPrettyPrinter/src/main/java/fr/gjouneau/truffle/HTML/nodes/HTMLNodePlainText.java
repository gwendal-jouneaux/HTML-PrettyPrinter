package fr.gjouneau.truffle.HTML.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags;

public class HTMLNodePlainText extends HTMLNodeBase {
	
	private final String content;

	public HTMLNodePlainText(String content, int sourceStart, int sourceEnd) {
		super(sourceStart, sourceEnd);
		this.content = content;
	}
	
	public boolean hasTag(Class<? extends Tag> tag) {
		if(tag == HTMLInstrumentationTags.Text.class) return true;
        return super.hasTag(tag);
    }

	@Override
	public String execute(VirtualFrame frame) {
		return content;
	}

	public String getContent() {
		return content;
	}
}
