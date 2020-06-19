package fr.gjouneau.truffle.HTML.nodes;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.SourceSection;

@NodeInfo(language = "HTML", description = "The root of all HTML Document")
public class HTMLNodeRoot extends RootNode{

    private SourceSection sourceSection;
	
	@Child private HTMLNodeBase html;

	public HTMLNodeRoot(TruffleLanguage<?> language, HTMLNodeBlockTag html) {
		super(language);
		this.html = html;
	}

	public HTMLNodeRoot(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, HTMLNodeBlockTag html) {
		super(language, frameDescriptor);
		this.html = html;
	}

	@Override
	public Object execute(VirtualFrame frame) {
		return "<!DOCTYPE html>\n" + html.execute(frame);
	}
	
	@Override
    @TruffleBoundary
    public final SourceSection getSourceSection() {
        return this.sourceSection;
    }
	
	public final void setSourceSection(SourceSection section) {
        sourceSection = section;
    }

    public final boolean hasSource() {
        return sourceSection != null;
    }
}
