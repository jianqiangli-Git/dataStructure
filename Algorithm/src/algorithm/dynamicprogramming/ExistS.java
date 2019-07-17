package algorithm.dynamicprogramming;

import java.util.Arrays;

public class ExistS {

	/**判断数组中是否存在几个元素的和等于给定的值
	 * 其中元素和 s 都是大于 0 的正整数
	 * 测试用例：[3,34,4,12,5,2]  s = 9  ==> True
	 * 理由：3+4+2=9
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3,34,4,12,5,2};
		ExistS es = new ExistS();
		
		boolean is = es.exist(arr, arr.length-1, 13);
		System.out.println("第一种是否存在："+is);
		
		boolean ie = es.ifExist(arr, 13);
		System.out.println("第二种是否存在："+ie);
		
	}
	
	//递归方法(如果s=0，不管数组元素如何，输出的都是 true)
	public boolean exist(int[] arr,int i,int s){    //判断数组 arr 中到下标 i 是否存在元素和为 s
		if(i==0){
			return arr[0] == s;    //如果只有一个元素，该元素等于 s 就满足，否则不满足
		}
		else if(s == 0){
			return true;         //如果 exist(arr[i],0) 说明在 i~arr.length-1 中已经找到了几个元素满足和为 s
		}
		else if(arr[i] > s){     //如果当前元素 arr[i]>s，就不能选 arr[i] 而应该在 0~(i-1) 中继续寻找
			return exist(arr, i-1, s);
		}
		else
			return exist(arr, i-1, s-arr[i]) || exist(arr, i-1, s); //如果选择当前元素，就看到 i-1有没有元素和满足 s-arr[i]
	}                                                               //如果不选当前元素，就看到 i-1有没有元素和满足 s，二者满足其一即可
	
	//非递归方法
	//将下标0~arr.length-1是否存在和为0~s的布尔值存在[arr.length-1,s+1]的二维数组中，需要时直接从存有算好结果的数组中取值
	public boolean ifExist(int[] arr,int s){
		int[] sArr = new int[s+1];   //开辟一个数组存储 0~s 共 s+1 不同的 s 值
		for(int i = 0; i<s+1; i++){
			sArr[i] = i;
		}
 		boolean[][] boolArr = new boolean[arr.length][s+1];  //开辟存储是否满足的布尔值数组,默认初始值是 false
 		System.out.println("布尔值数组初始值是：");
		for(int i=0;i<arr.length;i++){
			System.out.println(Arrays.toString(boolArr[i]));
		}
		
//		boolArr[0][arr[0]] = true;       //i=0 时，只有 s==arr[0] 的那个位置为true，其他位置都不能满足 到下标 0 的元素和为 s
		
		for(int i=0;i<arr.length;i++){          
			for(int j=0;j<s+1;j++){  
				if(i==0){
					if(arr[0]==sArr[j]){
						boolArr[0][j] = true;  //i=0 时，只有 s==arr[0] 的那个位置为true，其他位置都不能满足 到下标 0 的元素和为 s
					}
					continue;
				}
				if(j == 0){
					boolArr[i][j] = true;   //j==0 是 s=0的列，前面已经分析，s=0，就满足 i~arr.length-1 有几个元素和为 s
				}
				else if(arr[i]>sArr[j]){    //如果arr[i]>当前 s 就不能选择arr[i]而去考虑 arr[i-1] 是否等于 s
					boolArr[i][j] = boolArr[i-1][sArr[j]];   //判断i-1是否等于s，若i-1等于s，那么就存在i等于s
				}
				else{       //一般情况，也就是选择当前元素，判断i-1是否等于s-arr[i] || 不选择当前元素，判断i-1 是否等于s
					boolArr[i][j] = boolArr[i-1][sArr[j]-arr[i]] || boolArr[i-1][sArr[j]];
				}
			}
		}
		
		return boolArr[arr.length-1][s];
	}
}

