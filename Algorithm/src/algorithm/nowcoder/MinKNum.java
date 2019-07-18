package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class MinKNum {

	/**输入n个整数，找出其中最小的K个数。
	 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {4,5,1,6,2,7,3,8};
		Solution20 s = new Solution20();
		ArrayList<Integer> listK = s.GetLeastNumbers_Solution(arr, 10);
		System.out.println(listK.toString());
		
		MinKNum mkn = new MinKNum();
		ArrayList<Integer> minK = mkn.GetLeastNumbers_Solution(arr, 4);
		
		System.out.println("第二种："+minK.toString());
	}
	
	//借用冒泡排序的方法，排出最小的k个数到数组最右边
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
//		int m = 1;
		for(int i=input.length-1;i>input.length-k-1;i--){			
//			System.out.println("第"+m+"次");			
			for(int j=0;j<i;j++){				
				if(input[j]<input[j+1]){
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
			}
//			m++;
		}
		//得到最后四位最小的数组
		System.out.println(Arrays.toString(input));
		for(int i=input.length-1;i>input.length-k-1;i--){
			list.add(input[i]);   //倒序存到 list 中最后四位就是升序的
		}
		return list;
	}

}
//思路:
//调用 Arrays 工具类的 sort 方法将输入的数组 input 生序排列，然后取前 k 个值存到 ArrayList 中
class Solution20 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	if(k>=input.length){
    		k=input.length;
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Arrays.sort(input);
    	System.out.println(Arrays.toString(input));
    	for(int i=0;i<k;i++){
    		list.add(input[i]);
    	}
        return list;
    }
}