package algorithm.leetcode;

public class NoCacheSwap {

	/**一种不用开辟辅助空间的交换方法
	 * @param args
	 */
	public static void main(String[] args) {
		NoCacheSwap ncs = new NoCacheSwap();
		int a = 1;
		int b = 2;

		ncs.swap2(a,b);
		System.out.println("在函数外：");
		System.out.println("a="+a);         //函数外a,b值不变(a=1,b=2)，因为是值传递
		System.out.println("b="+b);
	}
	
	public void swap1(int a,int b){
		System.out.println("交换前：");
		System.out.println("a="+a);
		System.out.println("b="+b);
		a = a + b;
		b = a - b;   //b=(a+b)-b=a 相当于 b=a
		a = a - b;   //a=a-(a-b)=b 相当于 a=b
		System.out.println("交换后：");
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	//使用位运算(按位异或)
	public void swap2(int a,int b){
		System.out.println("交换前：");
		System.out.println("a="+a);
		System.out.println("b="+b);
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("交换后：");
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
}
