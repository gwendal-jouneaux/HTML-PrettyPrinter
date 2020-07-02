package fr.gjouneau.truffle.HTML.instrumentation;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.api.instrumentation.Tag;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags.*;

public class HTMLInstrumentationTags {

	private HTMLInstrumentationTags() {
	}
	
	public static final Class<?>[] ALL = new Class[]{A.class,
			ABBR.class,
			ADDRESS.class,
			AREA.class,
			ARTICLE.class,
			ASIDE.class,
			AUDIO.class,
			B.class,
			BASE.class,
			BDI.class,
			BDO.class,
			BLOCKQUOTE.class,
			BODY.class,
			BR.class,
			BUTTON.class,
			CANVAS.class,
			CAPTION.class,
			CITE.class,
			CODE.class,
			COL.class,
			COLGROUP.class,
			DATA.class,
			DATALIST.class,
			DD.class,
			DEL.class,
			DETAILS.class,
			DFN.class,
			DIALOG.class,
			DIV.class,
			DL.class,
			DT.class,
			EM.class,
			EMBED.class,
			FIELDSET.class,
			FIGCAPTION.class,
			FIGURE.class,
			FOOTER.class,
			FORM.class,
			H1.class,
			H2.class,
			H3.class,
			H4.class,
			HEAD.class,
			HEADER.class,
			HR.class,
			HTML.class,
			I.class,
			IFRAME.class,
			IMG.class,
			INPUT.class,
			INS.class,
			KBD.class,
			LABEL.class,
			LEGEND.class,
			H5.class,
			LI.class,
			LINK.class,
			MAIN.class,
			MAP.class,
			MARK.class,
			META.class,
			METER.class,
			NAV.class,
			NOSCRIPT.class,
			OBJECT.class,
			OL.class,
			OPTGROUP.class,
			OPTION.class,
			H6.class,
			OUTPUT.class,
			P.class,
			PARAM.class,
			PICTURE.class,
			PRE.class,
			PROGRESS.class,
			Q.class,
			RP.class,
			RT.class,
			RUBY.class,
			S.class,
			SAMP.class,
			SCRIPT.class,
			SECTION.class,
			SELECT.class,
			SMALL.class,
			SOURCE.class,
			SPAN.class,
			STRONG.class,
			STYLE.class,
			SUB.class,
			SUMMARY.class,
			SUP.class,
			SVG.class,
			TABLE.class,
			TBODY.class,
			TD.class,
			TEMPLATE.class,
			TEXTAREA.class,
			TFOOT.class,
			TH.class,
			THEAD.class,
			TIME.class,
			TITLE.class,
			TR.class,
			TRACK.class,
			U.class,
			UL.class,
			VAR.class,
			VIDEO.class,
			WBR.class,
			Text.class,
			BlockElement.class,
			VoidElement.class,
			Attribute.class};
	
	public static final Class<?>[] VOID_ELEMENT = new Class[]{
            AREA.class,
            BASE.class,
            BR.class,
            COL.class,
            EMBED.class,
            HR.class,
            IMG.class,
            INPUT.class,
            LINK.class,
            META.class,
            PARAM.class,
            SOURCE.class,
            TRACK.class,
            WBR.class
	};
	
	@Tag.Identifier("Unknown")
	public static final class Unknown extends Tag {
		private Unknown() {
		}
	}
	
	@Tag.Identifier("Attribute")
	public static final class Attribute extends Tag {
		private Attribute() {
		}
	}
	
	@Tag.Identifier("Text")
	public static final class Text extends Tag {
		private Text() {
		}
	}
	
	@Tag.Identifier("VoidElement")
	public static final class VoidElement extends Tag {
		private VoidElement() {
		}
	}
	
	@Tag.Identifier("BlockElement")
	public static final class BlockElement extends Tag {
		private BlockElement() {
		}
	}
	
	@Tag.Identifier("A")
	public static final class A extends Tag {
		private A() {
		}
	}

	@Tag.Identifier("ABBR")
	public static final class ABBR extends Tag {
		private ABBR() {
		}
	}

	@Tag.Identifier("ADDRESS")
	public static final class ADDRESS extends Tag {
		private ADDRESS() {
		}
	}

	@Tag.Identifier("AREA")
	public static final class AREA extends Tag {
		private AREA() {
		}
	}

	@Tag.Identifier("ARTICLE")
	public static final class ARTICLE extends Tag {
		private ARTICLE() {
		}
	}

	@Tag.Identifier("ASIDE")
	public static final class ASIDE extends Tag {
		private ASIDE() {
		}
	}

	@Tag.Identifier("AUDIO")
	public static final class AUDIO extends Tag {
		private AUDIO() {
		}
	}

	@Tag.Identifier("B")
	public static final class B extends Tag {
		private B() {
		}
	}

	@Tag.Identifier("BASE")
	public static final class BASE extends Tag {
		private BASE() {
		}
	}

	@Tag.Identifier("BDI")
	public static final class BDI extends Tag {
		private BDI() {
		}
	}

	@Tag.Identifier("BDO")
	public static final class BDO extends Tag {
		private BDO() {
		}
	}

	@Tag.Identifier("BLOCKQUOTE")
	public static final class BLOCKQUOTE extends Tag {
		private BLOCKQUOTE() {
		}
	}

	@Tag.Identifier("BODY")
	public static final class BODY extends Tag {
		private BODY() {
		}
	}

	@Tag.Identifier("BR")
	public static final class BR extends Tag {
		private BR() {
		}
	}

	@Tag.Identifier("BUTTON")
	public static final class BUTTON extends Tag {
		private BUTTON() {
		}
	}

	@Tag.Identifier("CANVAS")
	public static final class CANVAS extends Tag {
		private CANVAS() {
		}
	}

	@Tag.Identifier("CAPTION")
	public static final class CAPTION extends Tag {
		private CAPTION() {
		}
	}

	@Tag.Identifier("CITE")
	public static final class CITE extends Tag {
		private CITE() {
		}
	}

	@Tag.Identifier("CODE")
	public static final class CODE extends Tag {
		private CODE() {
		}
	}

	@Tag.Identifier("COL")
	public static final class COL extends Tag {
		private COL() {
		}
	}

	@Tag.Identifier("COLGROUP")
	public static final class COLGROUP extends Tag {
		private COLGROUP() {
		}
	}

	@Tag.Identifier("DATA")
	public static final class DATA extends Tag {
		private DATA() {
		}
	}

	@Tag.Identifier("DATALIST")
	public static final class DATALIST extends Tag {
		private DATALIST() {
		}
	}

	@Tag.Identifier("DD")
	public static final class DD extends Tag {
		private DD() {
		}
	}

	@Tag.Identifier("DEL")
	public static final class DEL extends Tag {
		private DEL() {
		}
	}

	@Tag.Identifier("DETAILS")
	public static final class DETAILS extends Tag {
		private DETAILS() {
		}
	}

	@Tag.Identifier("DFN")
	public static final class DFN extends Tag {
		private DFN() {
		}
	}

	@Tag.Identifier("DIALOG")
	public static final class DIALOG extends Tag {
		private DIALOG() {
		}
	}

	@Tag.Identifier("DIV")
	public static final class DIV extends Tag {
		private DIV() {
		}
	}

	@Tag.Identifier("DL")
	public static final class DL extends Tag {
		private DL() {
		}
	}

	@Tag.Identifier("DT")
	public static final class DT extends Tag {
		private DT() {
		}
	}

	@Tag.Identifier("EM")
	public static final class EM extends Tag {
		private EM() {
		}
	}

	@Tag.Identifier("EMBED")
	public static final class EMBED extends Tag {
		private EMBED() {
		}
	}

	@Tag.Identifier("FIELDSET")
	public static final class FIELDSET extends Tag {
		private FIELDSET() {
		}
	}

	@Tag.Identifier("FIGCAPTION")
	public static final class FIGCAPTION extends Tag {
		private FIGCAPTION() {
		}
	}

	@Tag.Identifier("FIGURE")
	public static final class FIGURE extends Tag {
		private FIGURE() {
		}
	}

	@Tag.Identifier("FOOTER")
	public static final class FOOTER extends Tag {
		private FOOTER() {
		}
	}

	@Tag.Identifier("FORM")
	public static final class FORM extends Tag {
		private FORM() {
		}
	}

	@Tag.Identifier("H1")
	public static final class H1 extends Tag {
		private H1() {
		}
	}

	@Tag.Identifier("H2")
	public static final class H2 extends Tag {
		private H2() {
		}
	}

	@Tag.Identifier("H3")
	public static final class H3 extends Tag {
		private H3() {
		}
	}

	@Tag.Identifier("H4")
	public static final class H4 extends Tag {
		private H4() {
		}
	}

	@Tag.Identifier("HEAD")
	public static final class HEAD extends Tag {
		private HEAD() {
		}
	}

	@Tag.Identifier("HEADER")
	public static final class HEADER extends Tag {
		private HEADER() {
		}
	}

	@Tag.Identifier("HR")
	public static final class HR extends Tag {
		private HR() {
		}
	}

	@Tag.Identifier("HTML")
	public static final class HTML extends Tag {
		private HTML() {
		}
	}

	@Tag.Identifier("I")
	public static final class I extends Tag {
		private I() {
		}
	}

	@Tag.Identifier("IFRAME")
	public static final class IFRAME extends Tag {
		private IFRAME() {
		}
	}

	@Tag.Identifier("IMG")
	public static final class IMG extends Tag {
		private IMG() {
		}
	}

	@Tag.Identifier("INPUT")
	public static final class INPUT extends Tag {
		private INPUT() {
		}
	}

	@Tag.Identifier("INS")
	public static final class INS extends Tag {
		private INS() {
		}
	}

	@Tag.Identifier("KBD")
	public static final class KBD extends Tag {
		private KBD() {
		}
	}

	@Tag.Identifier("LABEL")
	public static final class LABEL extends Tag {
		private LABEL() {
		}
	}

	@Tag.Identifier("LEGEND")
	public static final class LEGEND extends Tag {
		private LEGEND() {
		}
	}

	@Tag.Identifier("H5")
	public static final class H5 extends Tag {
		private H5() {
		}
	}

	@Tag.Identifier("LI")
	public static final class LI extends Tag {
		private LI() {
		}
	}

	@Tag.Identifier("LINK")
	public static final class LINK extends Tag {
		private LINK() {
		}
	}

	@Tag.Identifier("MAIN")
	public static final class MAIN extends Tag {
		private MAIN() {
		}
	}

	@Tag.Identifier("MAP")
	public static final class MAP extends Tag {
		private MAP() {
		}
	}

	@Tag.Identifier("MARK")
	public static final class MARK extends Tag {
		private MARK() {
		}
	}

	@Tag.Identifier("META")
	public static final class META extends Tag {
		private META() {
		}
	}

	@Tag.Identifier("METER")
	public static final class METER extends Tag {
		private METER() {
		}
	}

	@Tag.Identifier("NAV")
	public static final class NAV extends Tag {
		private NAV() {
		}
	}

	@Tag.Identifier("NOSCRIPT")
	public static final class NOSCRIPT extends Tag {
		private NOSCRIPT() {
		}
	}

	@Tag.Identifier("OBJECT")
	public static final class OBJECT extends Tag {
		private OBJECT() {
		}
	}

	@Tag.Identifier("OL")
	public static final class OL extends Tag {
		private OL() {
		}
	}

	@Tag.Identifier("OPTGROUP")
	public static final class OPTGROUP extends Tag {
		private OPTGROUP() {
		}
	}

	@Tag.Identifier("OPTION")
	public static final class OPTION extends Tag {
		private OPTION() {
		}
	}

	@Tag.Identifier("H6")
	public static final class H6 extends Tag {
		private H6() {
		}
	}

	@Tag.Identifier("OUTPUT")
	public static final class OUTPUT extends Tag {
		private OUTPUT() {
		}
	}

	@Tag.Identifier("P")
	public static final class P extends Tag {
		private P() {
		}
	}

	@Tag.Identifier("PARAM")
	public static final class PARAM extends Tag {
		private PARAM() {
		}
	}

	@Tag.Identifier("PICTURE")
	public static final class PICTURE extends Tag {
		private PICTURE() {
		}
	}

	@Tag.Identifier("PRE")
	public static final class PRE extends Tag {
		private PRE() {
		}
	}

	@Tag.Identifier("PROGRESS")
	public static final class PROGRESS extends Tag {
		private PROGRESS() {
		}
	}

	@Tag.Identifier("Q")
	public static final class Q extends Tag {
		private Q() {
		}
	}

	@Tag.Identifier("RP")
	public static final class RP extends Tag {
		private RP() {
		}
	}

	@Tag.Identifier("RT")
	public static final class RT extends Tag {
		private RT() {
		}
	}

	@Tag.Identifier("RUBY")
	public static final class RUBY extends Tag {
		private RUBY() {
		}
	}

	@Tag.Identifier("S")
	public static final class S extends Tag {
		private S() {
		}
	}

	@Tag.Identifier("SAMP")
	public static final class SAMP extends Tag {
		private SAMP() {
		}
	}

	@Tag.Identifier("SCRIPT")
	public static final class SCRIPT extends Tag {
		private SCRIPT() {
		}
	}

	@Tag.Identifier("SECTION")
	public static final class SECTION extends Tag {
		private SECTION() {
		}
	}

	@Tag.Identifier("SELECT")
	public static final class SELECT extends Tag {
		private SELECT() {
		}
	}

	@Tag.Identifier("SMALL")
	public static final class SMALL extends Tag {
		private SMALL() {
		}
	}

	@Tag.Identifier("SOURCE")
	public static final class SOURCE extends Tag {
		private SOURCE() {
		}
	}

	@Tag.Identifier("SPAN")
	public static final class SPAN extends Tag {
		private SPAN() {
		}
	}

	@Tag.Identifier("STRONG")
	public static final class STRONG extends Tag {
		private STRONG() {
		}
	}

	@Tag.Identifier("STYLE")
	public static final class STYLE extends Tag {
		private STYLE() {
		}
	}

	@Tag.Identifier("SUB")
	public static final class SUB extends Tag {
		private SUB() {
		}
	}

	@Tag.Identifier("SUMMARY")
	public static final class SUMMARY extends Tag {
		private SUMMARY() {
		}
	}

	@Tag.Identifier("SUP")
	public static final class SUP extends Tag {
		private SUP() {
		}
	}

	@Tag.Identifier("SVG")
	public static final class SVG extends Tag {
		private SVG() {
		}
	}

	@Tag.Identifier("TABLE")
	public static final class TABLE extends Tag {
		private TABLE() {
		}
	}

	@Tag.Identifier("TBODY")
	public static final class TBODY extends Tag {
		private TBODY() {
		}
	}

	@Tag.Identifier("TD")
	public static final class TD extends Tag {
		private TD() {
		}
	}

	@Tag.Identifier("TEMPLATE")
	public static final class TEMPLATE extends Tag {
		private TEMPLATE() {
		}
	}

	@Tag.Identifier("TEXTAREA")
	public static final class TEXTAREA extends Tag {
		private TEXTAREA() {
		}
	}

	@Tag.Identifier("TFOOT")
	public static final class TFOOT extends Tag {
		private TFOOT() {
		}
	}

	@Tag.Identifier("TH")
	public static final class TH extends Tag {
		private TH() {
		}
	}

	@Tag.Identifier("THEAD")
	public static final class THEAD extends Tag {
		private THEAD() {
		}
	}

	@Tag.Identifier("TIME")
	public static final class TIME extends Tag {
		private TIME() {
		}
	}

	@Tag.Identifier("TITLE")
	public static final class TITLE extends Tag {
		private TITLE() {
		}
	}

	@Tag.Identifier("TR")
	public static final class TR extends Tag {
		private TR() {
		}
	}

	@Tag.Identifier("TRACK")
	public static final class TRACK extends Tag {
		private TRACK() {
		}
	}

	@Tag.Identifier("U")
	public static final class U extends Tag {
		private U() {
		}
	}

	@Tag.Identifier("UL")
	public static final class UL extends Tag {
		private UL() {
		}
	}

	@Tag.Identifier("VAR")
	public static final class VAR extends Tag {
		private VAR() {
		}
	}

	@Tag.Identifier("VIDEO")
	public static final class VIDEO extends Tag {
		private VIDEO() {
		}
	}

	@Tag.Identifier("WBR")
	public static final class WBR extends Tag {
		private WBR() {
		}
	}
	
	public static Map<String,Class<? extends Tag>> getMapping(){
		Map<String,Class<? extends Tag>> out = new HashMap<String,Class<? extends Tag>>();
		for (Class<?> c : ALL) {
			try {
				out.put(c.getSimpleName().toUpperCase(), (Class<? extends Tag>) c);
			} catch (Exception e) {}
		}
		return out;
	}

}
