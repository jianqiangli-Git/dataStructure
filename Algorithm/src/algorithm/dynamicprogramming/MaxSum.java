package algorithm.dynamicprogramming;

public class MaxSum {

	/**给一个数组，返回它的最大连续子序列的和
	 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
	 * 测试用例：[1,-2,3,10,-4,7,2,-5] ==> 18
	 * 这就是 algorithm.nowcoder 中的 MaxSum 题
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,-2,3,10,-4,7,2,-5};
		MaxSum ms = new MaxSum();
		int max = ms.maxSum(arr);
		System.out.println(max);
	}
	
	public int maxSum(int[] arr){
		int res = arr[0]; //记录当前所有子数组的和的最大值
        int max=arr[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < arr.length; i++) {
            max=Math.max(max+arr[i], arr[i]);
            res=Math.max(max, res);
        }
        return res;
	}
}
