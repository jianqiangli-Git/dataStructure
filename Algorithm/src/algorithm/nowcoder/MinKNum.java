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