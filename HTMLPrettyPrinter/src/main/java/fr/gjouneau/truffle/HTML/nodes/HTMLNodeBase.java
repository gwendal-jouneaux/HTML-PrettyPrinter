package fr.gjouneau.truffle.HTML.nodes;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;

@NodeInfo(language = "HTML", description = "The abstract base node for all HTML nodes")
@GenerateWrapper
public abstract class HTMLNodeBase extends Node implements InstrumentableNode {

	private static final int NO_SOURCE = -1;
    private static final int UNAVAILABLE_SOURCE = -2;

    private int sourceCharIndex = NO_SOURCE;
    private int sourceLength;
    
    public HTMLNodeBase() {}
    
    public HTMLNodeBase(int sourceStart, int sourceEnd) {
    	setSourceSection(sourceStart, sourceEnd-sourceStart);
	}
	
	@Override
    @TruffleBoundary
    public final SourceSection getSourceSection() {
        if (sourceCharIndex == NO_SOURCE) {
            // AST node without source
            return null;
        }
        RootNode rootNode = getRootNode();
        if (rootNode == null) {
            // not yet adopted yet
            return null;
        }
        SourceSection rootSourceSection = rootNode.getSourceSection();
        if (rootSourceSection == null) {
            return null;
        }
        Source source = rootSourceSection.getSource();
        if (sourceCharIndex == UNAVAILABLE_SOURCE) {
            if (!rootSourceSection.isAvailable()) {
                return rootSourceSection;
            } else {
                return source.createUnavailableSection();
            }
        } else {
            return source.createSection(sourceCharIndex, sourceLength);
        }
    }
	
	public final void setSourceSection(int charIndex, int length) {
        assert sourceCharIndex == NO_SOURCE : "source must only be set once";
        if (charIndex < 0) {
            throw new IllegalArgumentException("charIndex < 0");
        } else if (length < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        this.sourceCharIndex = charIndex;
        this.sourceLength = length;
    }

    public final boolean hasSource() {
        return sourceCharIndex != NO_SOURCE;
    }

	public boolean isInstrumentable() {
		return hasSource();
	}
	
	public boolean hasTag(Class<? extends Tag> tag) {
        return false;
    }
	
	public WrapperNode createWrapper(ProbeNode probe) {
		return new HTMLNodeBaseWrapper(this, probe);
	}
	
	public abstract String execute(VirtualFrame frame);

}
