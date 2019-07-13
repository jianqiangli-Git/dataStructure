package algorithm.nowcoder;

public class DiGui {

	/**µÝ¹é²âÊÔ
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiGui dg = new DiGui();
		int r = dg.digui(5);
//		System.out.println(r);
	}
	int j = 0;
	public int digui(int n){
		j++;
		System.out.println(j+" ²ã");
		if(n==0)//µÝ¹é±ß½ç
			return 1;	 
		int result =  n*digui(n-1);//µÝ¹é¹«Ê½	
		System.out.println("result: "+result);
		return result;
	}
}
