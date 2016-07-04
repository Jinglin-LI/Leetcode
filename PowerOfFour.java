public class PowerOfFour {
	public static void main(String[] args) {
		if (new PowerOfFour().isPowerOfFour2(16))
			System.out.println("True");
		else
			System.out.println("False");
	}
	public boolean isPowerOfFour(int num) {
		if (num <= 0)
			return false;
		if (num == 1)
			return true;
		while (num != 1) {
			if ((num & 1) != 0)
				return false;
			num = num >> 1;
			if ((num & 1) != 0)
				return false;
			num = num >> 1;
		}
		if (num == 1)
			return true;
		return false;
	}
	public boolean isPowerOfFour2(int num) {
		return num > 0 && (num & (num - 1)) == 0 && num % 3 == 1;
	}
	public boolean isPowerOfFour3(int num) {
	       return num > 0 && 1073741824 % num == 0 && num % 3 == 1;
	}
}
