package leetcode;

public class NoCacheSwap {

	/**一种不用开辟辅助空间的交换方法
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1;
		int b = 2;


		a = a + b;
		b = a - b;   //b=(a+b)-b=a 相当于 b=a
		a = a - b;   //a=a-(a-b)=b 相当于 a=b
		
		System.out.println("a="+a);
		System.out.println("b="+b);

	}
	
}
