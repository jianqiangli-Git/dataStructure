package resource.list;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = null;
		for(int i=0;i<3;i++){
			System.out.println(i);  
			arr[i] = i;      //会引发 java.lang.NullPointerException 异常
		}

	}

}
