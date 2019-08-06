package examination;

import java.util.Scanner;

	/**题目描述
	 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
	 * 并且小Q对于能否被3整除这个性质很感兴趣。
	 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
	 * 输入描述:
	 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
	 * 输出描述:
	 * 输出一个整数, 表示区间内能被3整除的数字个数。
	 * 输入：
	 * 2 5
	 * 输出：
	 * 3
	 * 说明：
	 * 12, 123, 1234, 12345...
	 * 其中12, 123, 12345能被3整除。
	 * @网易
	 */
//public class CountSumDividedBy3 {
//	public static void main(String[] args) {
//		// 能被3整除的数其各位之和为3的倍数，因此题目的关键是找到 l~r 之间的数，
//		// 可以发现，每次在末尾加上的数是前一个数加1,数字的结尾 i 代表了第 i 个数，例如第二个数是12，第10个数结尾是10
//		// 可以利用前一个数 * 10的第i个数中i的位数次方 再加 i，得到第i个数，然后对第i个数判断
//		// 这个方法只在15个以前有效，因为数字越来越大，long也容纳不下。问题的关键成为了如何存下这么大的数
//		Scanner s = new Scanner(System.in);
//		int l = s.nextInt();   //接收区间的左端
//		int r = s.nextInt();   //接收区间的右端
//		CountSumDividedBy3 csb = new CountSumDividedBy3();
//		int countSum = 0;
//		for(int i=l;i<=r;i++){    //得到i~r区间的数
//			long num = 0;
//			for(int j=1;j<=i;j++){     //区间中的某个数i得到从1~i组成的数
//				int count = csb.countDigit(j);
//				num = j+num*(long)Math.pow(10, count);  //遇到2位数则在前数基础上*100
//				System.out.println("nm:"+num);
//			}
//			System.out.println("num:"+num);
//			if(csb.canbeDivide(num)){
//				countSum++;
//			}
//		}
//		System.out.println(countSum);
//	}
//	
//	//定义判断能否被3整除的方法
//	boolean canbeDivide(long i){
//		long sum = 0;
//		while(i>=10){
//			long num = i%10;  //获得i的最后一位数
//			sum = sum + num;
//			i = i/10;        //去掉i的最后一位数
//		}
//		sum = sum+i;
//		if(sum%3==0){
//			return true;
//		}
//		return false;
//	}
//	
//	//定义判断一个数位数的方法
//	int countDigit(long i){
//		int count = 0;
//		while(i>=10){
//			count++;
//			i = i/10;
//		}
//		count++;
//		return count;
//	}
//}

/**
 * 第二种方法，利用字符串拼接，再将字符串转化为数字加以判断
 */
//public class CountSumDividedBy3{
//	public static void main(String[] args) {	
//		Scanner s = new Scanner(System.in);
//		int l = s.nextInt();   //接收区间的左端
//		int r = s.nextInt();   //接收区间的右端
//		System.out.println("l:"+l+" r:"+r);
//		StringBuilder stringl = new StringBuilder("");
//		StringBuilder stringr = new StringBuilder("");
//		int count = 0;
//		for(int i=1;i<=r;i++){
//			if(i<l){
//				stringl.append(i);
//			}
//			if(i>=l){
//				stringr = stringl;
//				stringr.append(i);
//				int num = Integer.parseInt(stringr.toString());
//				System.out.println("num:"+num);
//				if(num%3==0){
//					count++;
//				}
//			}
//		}
//		System.out.println(count);
//	}
//}

/**
 * 一个数所有位数的和相加如果等于3的倍数，则这个整数是3的倍数。 这里第一个数是1，第二个是12，第三个是123……第n个数是123……(n-1)n，各个位之和可以算成(i+1)*i/2,
 * 这里如果是大于等于两位数，它算成一个数和把每一位分开计算对3取余的结果都是一样的，例如123~10的和为55，各位和是45+1=46，55和46的各位和都是10.所以没关系。 所以，直接遍历l到r，根据通项公式判断即可
 */
//public class CountSumDividedBy3{
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int l = s.nextInt();   //接收区间的左端
//		int r = s.nextInt();   //接收区间的右端
//		int count = 0;
//		for(int i=l;i<=r;i++){
//			if((1+i)*i/2%3 == 0){
//				count++;
//			}
//		}
//		System.out.println(count);
//	}
//}

/**
 * 写出来当插入i以后的余数的规律：
 * i = 1 ----> 1
 * i = 2 ----> 0
 * i = 3 ----> 0
 * i = 4 ----> 1
 * i = 5 ----> 0
 * i = 6 ----> 0
 * i = 7 ----> 1
 * 其中余数为1的就是不能整除的。
 * 发现在区间[1,x]之间共计有 fuck(x) = (x+2)/3 个1，剩下的都满足要求.
 * 那么在区间[l, r]上的 r-l+1个 数字中，必须抠掉 fuck(r) - fuck(l-1) 个不满足要求的数字。
 * 直接打印出来就可以了，O(1)，不需要循环遍历。
 */
public class CountSumDividedBy3{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();   //接收区间的左端
		int r = s.nextInt();   //接收区间的右端
		int count = 0;
		count = (r-l+1) - fuck(r)+fuck(l-1);
		System.out.println(count);
		
	}
	//(x+2)/3 的想法是由于每3个是一组会加1，假如是1它包含了一个1，加2后凑成了3个，于是当前数字+2看有几组(每3个为一组)
	public static int fuck(int x){
		return (x+2)/3; 
	}
}

