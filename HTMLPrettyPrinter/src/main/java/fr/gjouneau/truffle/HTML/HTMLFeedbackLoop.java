package fr.gjouneau.truffle.HTML;

import com.oracle.truffle.adaptable.language.FeedbackLoop;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import com.oracle.truffle.api.nodes.Node;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags;

@Registration(id = HTMLFeedbackLoop.ID, name = "FeedbackLoop", version = "20.0.0", services = HTMLFeedbackLoop.class)
public class HTMLFeedbackLoop extends FeedbackLoop<HTMLLanguage, HTMLAdaptationContext> {

	@Override
	protected Class<? extends Tag> getFeedbackLoopTrigger() {
		return HTMLInstrumentationTags.HTML.class;
	}

	@Override
	protected boolean additionalFilter(Node trigger) {
		System.err.println("THE LOOP WORKS");
		return true;
	}
	
	//@Override
    //protected final OptionDescriptors getOptionDescriptors() {
    //    return new HTMLFeedbackLoopOptionDescriptors();
    //}

}
