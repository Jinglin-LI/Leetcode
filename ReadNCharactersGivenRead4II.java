public class ReadNCharactersGiveRead4 {
        Queue<Character> remain = new LinkedList<>();
	public int read2 (char[] buf, int n) {
		int i = 0;
		// 先读queue里面的暂存字符
		while (i < n && !remain.isEmpty()) {
			buf[i] = remain.poll();
			i++;
		}
		for (; i < n; i += 4) {
			char[] temp = new char[4];
			int len = read4(temp);
			if (len > n - i) {
				System.arraycopy(temp, 0, buf, i, n - i);
				for (int j = n - i; j < len; j++) {
					remain.add(temp[j]);
				}
			}
			else {
				System.arraycopy(temp, 0, buf, i, len);
			}
			if (len < 4)
				return Math.min(i + len, n);
		}
		return n;
	}
	
}
