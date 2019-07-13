package algorithm.nowcoder;

public class FragJump {

	/**一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution6 s = new Solution6();
		int num = s.JumpFloor(4);
		System.out.println(num);

	}

}
//递归法
//可以发现递归适用于：
//1.当前结果和前面的结果有关，于是关键就是找到这种规律，也就是递推关系
//2.找到和不同情况有关的结束条件(比如这里的递推关系中有前一次是1步和2步的不同情况，那么结束条件就是跳1步和跳2步时的方案数)
//另外，借鉴斐波拉切，还可以使用非递归方式
class Solution6 {
    public int JumpFloor(int target) {
    	if(target==1){
    		return 1;
    	}
    	if(target==2){ //如果台阶数是2就有两个方案(1,1)(2)
    		return 2;
    	}
    	return JumpFloor(target-2)+JumpFloor(target-1);//跳到第n阶的方案数是上一次跳1步和上一次跳2步的方案之和

    }
}
