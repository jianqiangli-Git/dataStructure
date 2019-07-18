package algorithm.nowcoder;

import java.util.ArrayList;

public class TwoNumEqualsS {

	/**输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
	 * 如果有多对数字的和等于S，输出两个数的乘积最小的
	 * 测试用例：[1,2,4,7,11,15],15  ==> [4,11]
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,4,7,11,15};
		TwoNumEqualsS tnes = new TwoNumEqualsS();
		ArrayList<Integer> list = tnes.FindNumbersWithSum(arr, 15);
		System.out.println(list);
	}
	
	//双端指针夹逼法
	//
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>(); //用来记录乘积最小的两个数的 List 
		int plow = 0;
		int phigh = array.length-1;
		while(plow<phigh){
			if(array[plow]+array[phigh]==sum){   //如果两个数的和等于sum，和相等乘积最小的两个数一定是差值最大的两个数
				System.out.println("找到了");
				list.add(0, array[plow]);        //由于是递增数组又是从两边向中间夹逼，因此差值一定是最大的，找到了和为sum一定满足乘积最小
				list.add(1, array[phigh]);
				break;
			}
			else if((array[plow]+array[phigh])<sum){
				plow++;
			}
			else{
				phigh--;
			}
		}
        return list;
    }

}
