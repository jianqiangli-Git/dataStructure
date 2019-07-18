package algorithm.nowcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TwoNums {

	/**一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	 * 测试用例：[2,4,3,6,3,2,5,5] ==> 4,6
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,4,3,6,3,2,5,5};
		Solution22 s = new Solution22();
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		s.FindNumsAppearOnce(arr, num1, num2);
		System.out.println(Arrays.toString(num1)+" "+Arrays.toString(num2));
	}

}

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
class Solution22 {
  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	  int[] num = new int[2];
	  //可以用map存储键(元素)值(次数)对
	  Queue<Integer> q = new LinkedList<Integer>();
      for(int i=0;i<array.length;i++){
    	  if(!q.contains(array[i])){
    		  q.add(array[i]);
    	  }
    	  else{
    		  q.remove(array[i]);
    	  }
      }
      for(int i=0;i<2;i++){
    	  num[i] = q.poll();
      }
      num1[0] = num[0];
      num2[0] = num[1];
  }
}
