/*
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class ImplementStrStr {
	public static void main(String[] args) {
		System.out.println(new ImplementStrStr().strStr2("abcabcd", "bcd"));
	}
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))                         // haystack.charAt(i + j)
					break;
				if (j == needle.length() - 1)
					return i;
			}
		}
		return -1;
	}
	public int strStr2(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				String sub = haystack.substring(i, needle.length() + i);
				if (sub.equals(needle))
					return i;
			}
		}
		return -1;
	}
}

    
