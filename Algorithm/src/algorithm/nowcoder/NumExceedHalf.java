package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NumExceedHalf {

	/**数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	 * 例如长度为9的数组{1,2,3,2,2,2,5,4,2}。数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,2,2,5,4,2};
		NumExceedHalf neh = new NumExceedHalf();
		int moreThanHalf = neh.MoreThanHalfNum_Solution(arr);
		System.out.println(moreThanHalf);
	}
	
	public int MoreThanHalfNum_Solution(int [] array) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		int len = array.length;
		for(int i=0;i<len;i++){
			if(map.keySet().contains(array[i])){
				int times = map.get(array[i]);
				map.put(array[i], ++times);
			}
			else{
				map.put(array[i], 1);
			}
		}
		System.out.println("map 的大小为："+map.size());
		for (Entry<Integer, Integer> set : map.entrySet()) {
			if(set.getValue()>len/2){
				return set.getKey();
			}
		}
        return 0;
    }

}
