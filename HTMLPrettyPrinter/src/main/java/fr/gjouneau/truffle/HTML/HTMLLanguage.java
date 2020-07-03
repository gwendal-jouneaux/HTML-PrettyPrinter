package fr.gjouneau.truffle.HTML;

import com.oracle.truffle.adaptable.language.AdaptationContext;
import com.oracle.truffle.adaptable.language.TruffleAdaptableLanguage;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;

import fr.gjouneau.truffle.HTML.instrumentation.HTMLInstrumentationTags.*;
import fr.gjouneau.truffle.HTML.nodes.HTMLNodeRoot;
import fr.gjouneau.truffle.HTML.parser.HTMLParser;
import fr.gjouneau.truffle.HTML.runtime.HTMLContext;

@TruffleLanguage.Registration(id = HTMLLanguage.ID, name = "HTML", defaultMimeType = HTMLLanguage.MIME_TYPE, characterMimeTypes = HTMLLanguage.MIME_TYPE, contextPolicy = ContextPolicy.SHARED, fileTypeDetectors = HTMLFileDetector.class)
@ProvidedTags({A.class,
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
	Attribute.class})
public class HTMLLanguage extends TruffleAdaptableLanguage<HTMLContext> {
	
	public static final String ID = "HTML";
    public static final String MIME_TYPE = "text/html";
    
    public static AdaptationContext getAdaptationContext() {
    	System.err.println("THE CONTEXT WORKS");
		return new HTMLAdaptationContext();
	}

	@Override
	protected HTMLContext createContext(Env env) {
		return new HTMLContext();
	}

	@Override
	protected boolean isObjectOfLanguage(Object object) {
		return object instanceof String;
	}
	
	@Override
    protected String toString(HTMLContext context, Object value) {
        return value.toString();
    }

	@Override
	protected CallTarget parse(ParsingRequest request) throws Exception {
		Source source = request.getSource();
		String code = (String) source.getCharacters();
		SourceSection rootSection = source.createSection(0, code.length());
		HTMLParser parser = new HTMLParser(code);

		HTMLNodeRoot html = parser.parse(this);
		html.setSourceSection(rootSection);
		html.adoptChildren();
		
		return Truffle.getRuntime().createCallTarget(html);
	}

}
