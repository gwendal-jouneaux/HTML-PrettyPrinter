package fr.gjouneau.truffle.HTML;

import java.io.IOException;
import java.nio.charset.Charset;

import com.oracle.truffle.api.TruffleFile;

public class HTMLFileDetector implements TruffleFile.FileTypeDetector{

	public String findMimeType(TruffleFile file) throws IOException {
		String name = file.getName();
        if (name != null && name.endsWith(".html")) {
            return HTMLLanguage.MIME_TYPE;
        }
        return null;
	}

	public Charset findEncoding(TruffleFile file) throws IOException {
		return null;
	}

}
