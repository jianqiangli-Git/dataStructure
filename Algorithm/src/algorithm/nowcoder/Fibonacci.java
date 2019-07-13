package algorithm.nowcoder;

public class Fibonacci {

	/**大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第1项为0）。
	 * n<=39
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5 s= new Solution5();
		int n = s.Fibonacci(4);
		System.out.println(n);

	}

}
//递归法，缺点就是消耗内存资源，重复计算，效率不高
//class Solution5 {
//	int result = 0 ;
//    public int Fibonacci(int n) {
//    	if(n==1){
//    		return 0;
//    	}
//    	else if(n==2){
//    		return 1;
//    	}
//    	else{
//    		result = Fibonacci(n-1)+Fibonacci(n-2); 
//    		return result;
//    	}    	
//    }
//}

//非递归法(第0个为0)
//[0][1][1][2][3][5]
// 0  1  2  3  4  5
class Solution5 {
	int result = 0 ;
    public int Fibonacci(int n) {
    	int f = 0;
    	int g = 1;
    	for(int i=0;i<n;i++){
    		g = f+g;   //让前两个数相加得到后一个数，重新为g
    		f = g-f;   //让得到的新的数减去曾经的f得到新的f，使f仍是紧挨着g的前面一个数 		
    	}
    	return f;
    }
}



