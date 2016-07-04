public class SumOfTwoIntegers {
	public static void main(String[] args) {
		System.out.println(new SumOfTwoIntegers().getSum(2, 2));
	}
	public int getSum(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = a & b;
		return getSum(sum, carry << 1);
	}
}
