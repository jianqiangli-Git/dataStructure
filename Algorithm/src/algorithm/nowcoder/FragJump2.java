package algorithm.nowcoder;

public class FragJump2 {

	/**一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * @param args
	 */
	public static void main(String[] args) {
		Solution7 s = new Solution7();
		int num = s.JumpFloorII(3);
		System.out.println(num);

	}

}
/**
 * f(0) = 1
 * f(1) = 1   //一阶只有一种方案
 * f(2) = f(2-1)+f(2-2) //跳2阶可以有一次跳1步和2步之和的这种递推关系
 * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)	
 * f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
 * f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)	
 * 可以得出：
 * f(n) = 2*f(n-1)
 * 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：

 *            | 1       ,(n=0 ) 

 * f(n) =     | 1       ,(n=1 )

              | 2*f(n-1),(n>=2)
 * @author Administrator
 *
 */
class Solution7 {
    public int JumpFloorII(int target) {
        if(target==1){
        	return 1;
        }
        else
        	return 2*JumpFloorII(target-1);
    }
}