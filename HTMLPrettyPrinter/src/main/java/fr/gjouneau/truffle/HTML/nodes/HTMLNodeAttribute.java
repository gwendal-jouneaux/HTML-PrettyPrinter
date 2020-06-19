package fr.gjouneau.truffle.HTML.nodes;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags;

@GenerateWrapper
public class HTMLNodeAttribute extends HTMLNodeBase {

	@CompilationFinal
	private final String name;
	@CompilationFinal
	private final String value;
	@CompilationFinal
	private final attributeType type;

	public enum attributeType {
		UNQUOTED, SIMPLE_QUOTED, DOUBLE_QUOTED
	}

	public HTMLNodeAttribute() {
		this.name = "";
		this.type = null;
		this.value = "";
	}
	
	public HTMLNodeAttribute(String name, String value, attributeType type, int sourceStart, int sourceEnd) {
		super(sourceStart, sourceEnd);
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public boolean isInstrumentable() {
		return true;
	}	
	
	public boolean hasTag(Class<? extends Tag> tag) {
		if(tag == HTMLInstrumentationTags.Attribute.class) return true;
        return super.hasTag(tag);
    }

	@Override
	public String execute(VirtualFrame frame) {
		if(type == null) return name;
		switch (type) {
		case UNQUOTED:
			return name+"="+value;
		case SIMPLE_QUOTED:
			return name+"='"+value+"'";
		case DOUBLE_QUOTED:
			return name+"=\""+value+"\"";
		default:
			return name;
		}
	}
	
	public WrapperNode createWrapper(ProbeNode probe) {
		return new HTMLNodeAttributeWrapper(this, probe);
	}
	
	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public attributeType getType() {
		return type;
	}

}
