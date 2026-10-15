package cyrilificate;

import java.util.Map;
import java.lang.Character;

public class CyrilicTranslator {
	public String translated_str = "";

	final public Map<Character, String> CyrilicCharacterMap = Map.ofEntries(
		Map.entry('a', "а"),
		Map.entry('b', "б"),
		Map.entry('v', "в"),
		Map.entry('g', "ч"),
		Map.entry('d', "д"),
		Map.entry('e', "е"),
		Map.entry('z', "з"),
		Map.entry('i', "и"),
		Map.entry('j', "й"),
		Map.entry('k', "к"),
		Map.entry('l', "л"),
		Map.entry('m', "м"),
		Map.entry('n', "н"),
		Map.entry('o', "о"),
		Map.entry('p', "п"),
		Map.entry('r', "р"),
		Map.entry('s', "с"),
		Map.entry('t', "т"),
		Map.entry('u', "у"),
		Map.entry('f', "ф"),
		Map.entry('h', "х"),
		Map.entry('y', "ы"),
		Map.entry('q', "г"),
		Map.entry('c', "ц"),
		Map.entry('w', "бве"),
		Map.entry('x', "екс")
	);

	public CyrilicTranslator(final String Latinized_Original_Text) {
		StringBuilder CyrilicTextBuilder = new StringBuilder("");

		for (short index = 0; index < Latinized_Original_Text.length(); index++)
		{
			Character curChar = Latinized_Original_Text.charAt(index);
			Character NextChar = (index + 1) == Latinized_Original_Text.length() ? '0' : Latinized_Original_Text.charAt(index + 1);

			// switch to check if special chars are needed	
			switch (curChar) {
				case 'i':
					if (NextChar == 'e') {
						CyrilicTextBuilder.append("ие");
						index++;
						break;
						// ие
					}	else if (NextChar == 'j') {
						// ы
						CyrilicTextBuilder.append("ы");
						index++;
						break;
					}
				case 'o':
					if (NextChar == 'e') {
						CyrilicTextBuilder.append("ꙋ");
						index++;
						break;
						// ꙋ
					} else if (NextChar == 'u') {
						CyrilicTextBuilder.append("ау");
						index++;
						break;
						// ау
					}
				case 'e':
					if (NextChar == 'u') {
						CyrilicTextBuilder.append("ѣ");
						index++;
						break;
						// ѣ
					} else if (NextChar == 'i') {
						CyrilicTextBuilder.append("ы");
						index++;
						break;
						// ы
					}
				case 'a':
					if (NextChar == 'u') {
						CyrilicTextBuilder.append("ау");
						index++;
						break;
						// ау
					}
				case 'u':
					if (NextChar == 'i') {
						CyrilicTextBuilder.append("ъ");
						index++;
						break;
						// ъ
					}
				case 's':
					if (NextChar == 'c' && Latinized_Original_Text.charAt(index + 2) == 'h') {
						CyrilicTextBuilder.append("щ");
						index += 2;
						break;
						// щ
					}
				case 'c':
					if (NextChar == 'h') {
						CyrilicTextBuilder.append("ч");
						index++;
						break;
						// ч	
					}
				default:
					String x = this.CyrilicCharacterMap.get(curChar);
					if (x != null) {
						CyrilicTextBuilder.append(x);
					} else {
						CyrilicTextBuilder.append(curChar);
					}
					// no special chars needed
				break;
			}
		}

		this.translated_str = CyrilicTextBuilder.toString();
	}
}

