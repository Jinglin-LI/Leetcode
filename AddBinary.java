/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class AddBinary {
	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("1", "111"));
	}
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			carry += a.charAt(i) - '0' + b.charAt(j) - '0';
			
			sb.insert(0, carry % 2);
			carry /= 2;
			i--;
			j--;
		}
		while (i >= 0) {
			carry += a.charAt(i) - '0';
			sb.insert(0, carry % 2);
			carry /= 2;
			i--;
		}
		while (j >= 0) {
			carry += b.charAt(j) - '0';
			sb.insert(0, carry % 2);
			carry /= 2;
			j--;
		}
		if (carry > 0)
			sb.insert(0, 1);
		return sb.toString();
	}
}
