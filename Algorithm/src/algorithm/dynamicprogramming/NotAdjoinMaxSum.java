package algorithm.dynamicprogramming;

public class NotAdjoinMaxSum {

	/**给定一个数组，要求选出不相邻的元素，使元素和最大，输出这个和的最大值
	 * [4,1,1,9,1] ==> 13 
	 * 选择不相邻的 4+9 达到和的最大
	 * 其中元素都是正整数
	 * 测试用例：[1,2,4,1,7,8,3] ==> 15     (1,4,7,3)
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,4,1,7,8,3};
		NotAdjoinMaxSum ms = new NotAdjoinMaxSum();
		int max = ms.refcMax(arr, arr.length-1);
		System.out.println("递归方法得到的最大值是："+max);
		
		int imax = ms.dpMax(arr);
		System.out.println("非递归方法得到的最大值是："+imax);
	}
	
	//递归的方法
	public int refcMax(int[] arr,int i){          //表示 arr 中到下标 i 的最大值
		if(i==0){  
			return arr[0];           //如果只有一个元素，最大值就是该元素
		}
		if(i==1){
			return Math.max(arr[0], arr[1]);      //如果有两个元素，最大值就是两个元素中的最大值
		}
		int select = refcMax(arr, i-2) + arr[i];  //如果选择下标 i 的元素，那么最大值是到 i-2 的最大值加当前值(下标i的值)
		int noSelect = refcMax(arr, i-1);         //如果不选择下标 i 的元素，那么最大值是到 i-1 的最大值
		return Math.max(select, noSelect);        //返回到下标 i 时，选择 i 和不选 i 两种情况中的最大值就是到下标 i 的最大值
	}
	
	//非递归
	//非递归就是将中间过程都存到数组中，需要某个中间值就直接从数组中取，而不是像递归那样重复计算多次
	public int dpMax(int[] arr){
		int[] iMax = new int[arr.length];   //将到下标 i 的最大值存到 iMax 中下标 i 的位置，因此需要 arr.length 的数组空间
		for(int i=0;i<arr.length;i++){
			if(i == 0){
				iMax[0] = arr[0];   //如果只有一个元素，最大值就是该元素，在 0 位置上存入这个最大值
				continue;
			}
			if(i == 1){
				iMax[1] = Math.max(arr[0], arr[1]); 
				continue;
			}
			int select = iMax[i-2] + arr[i];  //如果选择下标 i 的元素，那么最大值是到 i-2 的最大值加当前值(下标i的值)
			int noSelect = iMax[i-1];         //同理
			iMax[i] = Math.max(select, noSelect);     //下标 i 存入到下标 i 时选择 i 和不选择 i 中的最大值
		}
		
		return iMax[arr.length-1];      //数组 arr 中的和最大值存在 iMax 中的最后一个(表示数组arr中到最后下标的最大值)
	}

}
