package algorithm.nowcoder;

public class TestDiGui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestDiGui t = new TestDiGui();
		t.test(3);
	}
	
	public int test(int n){
		if(n==1){
			System.out.println("返回");
			return 1;
		}
		int t1 = test(n-1);
		System.out.println("我在t1执行后");
		
		int t2 = test(n-1);		
		System.out.println("t1:"+t1);
		System.out.println("我在t1打印后");
		System.out.println("t2:"+t2);
		return t1;
	}

}
