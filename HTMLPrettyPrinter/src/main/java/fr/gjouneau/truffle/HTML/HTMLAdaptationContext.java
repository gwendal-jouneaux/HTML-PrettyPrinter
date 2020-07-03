package fr.gjouneau.truffle.HTML;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.adaptable.language.AdaptationContext;
import com.oracle.truffle.adaptable.language.decision.model.Resource;

public class HTMLAdaptationContext extends AdaptationContext<HTMLLanguage> {

	@Override
	public Map<String, Double> loadUserConfig() {
		Map<String, Double> out = new HashMap<String, Double>();
		out.put("Energy", Double.parseDouble(System.getenv("ADAPTABLE_HTML_ENERGY")) / 100.0);
		System.err.println("\tENERGY = " + out.get("Energy"));
		out.put("Accuracy", Double.parseDouble(System.getenv("ADAPTABLE_HTML_ACCURACY")) / 100.0);
		System.err.println("\tACCURACY = " + out.get("Accuracy"));
		return out;
	}

	@Override
	public String[] softgoalIDs() {
		return new String[] {"Energy", "Accuracy"};
	}

	@Override
	protected Resource[] createResources() {
		return new Resource[] {};
	}

}
