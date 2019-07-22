package algorithm.nowcoder;

public class HannoiTower {

	/**汉诺塔经典递归问题
	 * 要求将所有盘子从A移动到C，要求每次只能移动一个盘子，并且大盘子不能在小盘子下面
	 * 输出最小移动次数的方法
	 * @param args
	 */
	public static void main(String[] args) {
		HannoiTower ht = new HannoiTower();
		ht.hannoi(3, 'A', 'B', 'C');

	}
	
	public void hannoi(int n,char A,char B,char C){   //n是盘子数，A是源柱，B是辅助柱，C是目标柱
		if(n==1){
			System.out.println(A+" --> "+C);   //如果只有一个盘子，直接将她移动到C柱
		}
		else{
			hannoi(n-1, A, C, B);    //将n-1个盘子从A借助C移动到B
			System.out.println(A+" --> "+C);  //将A移动到C
			hannoi(n-1, B, A, C);    //最后将n-1个盘子从B借助A移动到C
		}
	}

}
