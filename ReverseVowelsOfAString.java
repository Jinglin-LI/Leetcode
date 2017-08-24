import java.util.*;
public class ReverseVowelsOfAString {
	public static void main(String[] args) {
		System.out.println(new ReverseVowelsOfAString().reverseVowels("leetcode"));
	}
	public String reverseVowels(String s) {
		if (s == null || s.length() <= 1)
			return s;
		char[] c = s.toCharArray();
		int i = 0; 
		int j = c.length - 1;
		while (i < j) {
			while (i < j && !isVowels(c[i]))
				i++;
			while (i < j && !isVowels(c[j]))
				j--;
			if (i < j) {				// 加不加condition都可
				char temp = c[i];
				c[i] = c[j];
				c[j] = temp;
				i++;
				j--;
			}
		}
	//	StringBuilder sb = new StringBuilder();
	//	for (char each : c)
	//		sb.append(each);
	//	return sb.toString();
		return new String(c);				 // 或者return String.valueOf(c);
		
	}
	private boolean isVowels(char a) {
		a = Character.toLowerCase(a);
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
			return true;
		return false;
	}
}
