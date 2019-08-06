package examination;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class FindJob {

	/**输入：
	 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
  	 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
	 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
	 * 保证不存在两项工作的报酬相同。
	 * 输出：
	 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择
	 * 测试用例：
	 * 3 3 
	 * 1 100 
	 * 10 1000 
	 * 1000000000 1001 
	 * 9 10 1000000000
	 * 输出：
	 * 100 
	 * 1000 
	 * 1001
	 * @网易
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = s.nextInt();
		int m = s.nextInt();
		int[] b = new int[m];       //记录小伙伴的能力数组
		for(int i=0;i<n;i++){
			int Di = s.nextInt();   //输入难度
			int Pi = s.nextInt();   //输入报酬
			map.put(Di, Pi);
		}		
		for(int i=0;i<m;i++){
			int Di = s.nextInt();   //输入能力
			b[i] = Di;
			if(!map.containsKey(Di)){
				map.put(Di, 0); //如果能力不在map的键中存在,就将它存到map中并设置报酬为0(如果在map中那么他的报酬就是对应的value不需要存)
			}			
		}
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);      //将 map 中的 key 排序
		int max = 0;
		for (Object key: keys) {
			max = Math.max(max, map.get(key));
			map.put((Integer) key, max);
		}
		for(int i=0;i<m;i++){
			System.out.println(map.get(b[i]));
		}
	}

}
