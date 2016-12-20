/*
 * https://segmentfault.com/a/1190000003794420
 * read4(char[])参数是buf数组第一个的指针。返回读取的真实长度。过程中拷贝了元素进入buffer
 * readNCharactersGivenRead4 返回的是，真实读取的长度。
 * 
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. 
For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note: The read function may be called multiple times.
 
 
 // 数组复制！
System提供了一个静态方法arraycopy(),我们可以使用它来实现数组之间的复制。其函数原型是：
public static void arraycopy(Object src,
                             int srcPos,
                             Object dest,
                             int destPos,
                             int length)
src:源数组；	srcPos:源数组要复制的起始位置；
dest:目的数组；	destPos:目的数组放置的起始位置；	length:复制的长度。
注意：src and dest都必须是同类型或者可以进行转换类型的数组．
有趣的是这个函数可以实现自己到自己复制，比如：
int[] fun ={0,1,2,3,4,5,6}; 
System.arraycopy(fun,0,fun,3,3);
则结果为：{0,1,2,0,1,2,6};
实现过程是这样的，先生成一个长度为length的临时数组,将fun数组中srcPos 
到srcPos+length-1之间的数据拷贝到临时数组中，再执行System.arraycopy(临时数组,0,fun,3,3)

 */


public class ReadNCharactersGiveRead4 {
	public int read(char[] buf, int n) {
		for (int i = 0; i < n; i += 4) {
			char[] temp = new char[4];
			int len = read4(temp);
			// 复制数组temp到buf中（temp的0位 -> buf的i位，长度为len与n-i的最小值）
			System.arraycopy(temp, 0, buf, i, Math.min(len, n - i));
			if (len < 4)
      
        // read4是从file中读取的四个char, 如果读完了n,或者读完了file,返回。
				return Math.min(i + len, n);				
		}
		return n;
	}

	private int read4(char[] temp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
