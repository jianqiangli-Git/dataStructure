package algorithm.nowcoder;

public class RecoveRect {

	/**我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
	 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution8 s = new Solution8();
		int num = s.RectCover(3);
		System.out.println(num);
	}

}
//依旧斐波拉切递归
//大矩形2*target，target代表了矩形个数，如果横着放，只能放一个，剩下矩形个数就是target-2，方案数为f(target-2)
//如果竖着放，另外一边也只能并排着放一个竖着的矩形，这时剩下矩形个数是target-2，方案数为f(target-2)
class Solution8 {
    public int RectCover(int target) {
    	if(target==1){
    		return 1;
    	}
    	if(target==2){
    		return 2;
    	}
        return RectCover(target-1)+RectCover(target-2);
    }
}