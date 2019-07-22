package algorithm.nowcoder;

import java.util.Arrays;

public class SumOneToN {
	/**
	 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
	 * @param args
	 */
	public static void main(String[] args) {
		int n=3;
		SumOneToN stn = new SumOneToN();
		int result = stn.Sum_Solution1(n);
		System.out.println(result);
	}
	
	//利用 1+2+3+...+n=n(n+1)/2 
//	int Sum_Solution(int n) {
//		boolean[][] bool = new boolean[n][n+1];
//		return sizeof(bool)>>1;        //c++中利用sizeof()测量数组的大小，然后右移一位实现除以2的操作  
//    }
	
	//利用 1+2+3+...+n=n(n+1)/2 = n²+n 
	int Sum_Solution(int n) {
		int sum = (int) (Math.pow(n, 2)+n);
		return sum >> 1;        //c++中利用sizeof()测量数组的大小，然后右移一位实现除以2的操作  
    }
	
	//解题思路：
	//1.需利用逻辑与的短路特性实现递归终止。
	//2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
	//3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
    public int Sum_Solution1(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);   //java中逻辑与 && 两边只能是逻辑判断，所以都要用判断是否大于0
        return sum;
    }
	
}
