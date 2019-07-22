package algorithm.nowcoder;

public class NumOfOne {

	/**求出任意非负整数区间中1出现的次数（从1 到 n 中 1 出现的次数）
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 0;
		NumOfOne noo = new NumOfOne();
		int num = noo.NumberOf1Between1AndN_Solution(n);
		System.out.println(num);
	}
	//计算从1~n(包括n)中1出现的次数
	//主要利用 %10 得到个位数  /10去掉个位数
	public int NumberOf1Between1AndN_Solution(int n) {
		if(n<0){
			return 0;
		}
		int num = 0;
		for(int i=1;i<n+1;i++){
			int temp = i;
			while(true){				
				if(i%10==1){     //对每个数 10 取模得到就是最低位
					num++;
				}
				i = i/10;        //对每个数除 10 得到的商就是原数字去掉个位数
				if(i<10){
					if(i==1)     //最后只剩下个位数，判断这个个位数(原数的最高位)是否为 1
						num++;
					i = temp;    //容易失误的点：最后 i 要重新等于for循环中的i，而不是除10操作后的i
					break;
				}
			}
		}		
	    return num;
    }
}
