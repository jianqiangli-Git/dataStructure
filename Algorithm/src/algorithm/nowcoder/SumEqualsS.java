package algorithm.nowcoder;

import java.util.ArrayList;

public class SumEqualsS {

	/**输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	 * 要求这个连续的序列至少包括2个数
	 * 测试用例：S=100 ==> [18,19,20,21,22],[9,10,11,12,13,14,15,16]
	 * @param args
	 */
	public static void main(String[] args) {
		SumEqualsS ses = new SumEqualsS();
		ArrayList<ArrayList<Integer>> list = ses.FindContinuousSequence(100);
		for (ArrayList<Integer> arrayList : list) {
			System.out.println(arrayList);
		}

	}
	
	//方法一：滑动窗口
	//如果窗口中的和小于s，右窗口滑动一个位置(相当于加一个数),如果窗口中的和大于s，左窗口滑动一个位置(相当于减一个数)
	//最后输出所有满足的序列，用List存储每个满足的序列
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		//ArrayList 存储每个满足的序列，序列中都是 Integer 类型的数据
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int plow = 1;   //起始位置从 1 开始
		int phigh = 2;  //连续位置，窗口右端为 2 
		while(plow<phigh){
			int winSum = (plow+phigh) * (phigh-plow+1)/2;
			if(winSum==sum){
				ArrayList<Integer> alist = new ArrayList<Integer>();
				for(int i=plow;i<=phigh;i++){
					alist.add(i);
				}
				list.add(alist);
				plow++;   //窗口的和等于sum此时应该窗口的左指针移动，因为右指针移动肯定导致 winSum>sum
			}
			else if(winSum>sum){
				plow++;
			}
			else{
				phigh++;
			}
		}
		return list;	    
	}

}

