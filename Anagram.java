package problem;

public class Anagram {
	public static void main(String[] args) {
		// 예상 output : "desserts" is an anagram of "stressed"!
		System.out.println(isAnagramOf("stressed", "desserts "));

		// 예상 output : "남해군" is an anagram of "해남군"!
		System.out.println(isAnagramOf("해남군", "남해군"));

		// 예상 output : "Oh lame saint" is an anagram of ""The Mona Lisa"!
		System.out.println(isAnagramOf("The Mona Lisa", "Oh lame saint"));

		// 예상 output : "Dirty man" is NOT an anagram of "Dormitory"!
		System.out.println(isAnagramOf("Dormitory", "Dirty man"));
		System.out.println(isAnagramOf("Dormitory", "Dirty room"));
		System.out.println(isAnagramOf("aab", "aba"));

	}

	private static String isAnagramOf(String original, String candidate) {
		// 내용을 채워주세요!
		String origin = original.toLowerCase().replaceAll(" ", "");
		String candit = candidate.toLowerCase().replaceAll(" ", "");
		int num = 0;
		boolean[] test = new boolean[origin.length()];

		if (origin.length() == candit.length()) {
			for (int i = 0; i < origin.length(); i++) {
				for (int j = 0; j < origin.length(); j++) {
					if (test[j] != true) {
						if (origin.charAt(i) == candit.charAt(j)) {
							test[j] = true;
							num++;
							break;
						}
					}
				}
			}
		} else {
			return " [ " + candidate + " ] " + " is NOT an anagram of " + " [ " + original + " ] ";
		}

		if (num == origin.length()) {
			return " [ " + candidate + " ] " + " is an anagram of " + " [ " + original + " ] ";
		} else {
			return " [ " + candidate + " ] " + " is NOT an anagram of " + " [ " + original + " ] ";
		}
	}
}
