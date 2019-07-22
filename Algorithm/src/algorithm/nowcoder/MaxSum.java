package algorithm.nowcoder;

public class MaxSum {

	/**给一个数组，返回它的最大连续子序列的和
	 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
	 * 测试用例：[1,-2,3,10,-4,7,2,-5] ==> 18
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,-2,3,10,-4,7,2,-5};
		Solution21 s = new Solution21();
		int max = s.FindGreatestSumOfSubArray(arr);
		System.out.println(max);
	}

}

/**
 * 使用动态规划
 * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
 * F（i）=max（F（i-1）+array[i] ， array[i]）
 * res：所有子数组的和的最大值
 * res=max（res，F（i））

 * 如数组[6, -3, -2, 7, -15, 1, 2, 2]
 * 初始状态：
 *     F（0）=6
 *     res=6
 * i=1：
 *     F（1）=max（F（0）-3，-3）=max（6-3，3）=3
 *     res=max（F（1），res）=max（3，6）=6
 * i=2：
 *     F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
 *     res=max（F（2），res）=max（1，6）=6
 * i=3：
 *     F（3）=max（F（2）+7，7）=max（1+7，7）=8
 *     res=max（F（2），res）=max（8，6）=8
 * i=4：
 *     F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
 *     res=max（F（4），res）=max（-7，8）=8
 * 以此类推
 * 最终res的值为8
 *
 */

//当进来一个新的数字 arr[i+1] 时，判断到他前面数字子序列和 a[i]+arr[i+1] 跟 arr[i+1] 哪个大，
//前者大就保留前者，后者大就说明前面连续数字加起来都不如后者一个新进来的数字大，前面数字就可以舍弃，
//从 arr[i+1] 开始，每次比较完都跟 max 比较一下，最后的 max 就是最大值。
class Solution21 {
    public int FindGreatestSumOfSubArray(int[] array) {
    	int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }
}
