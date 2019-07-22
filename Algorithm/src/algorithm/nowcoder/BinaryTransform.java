package algorithm.nowcoder;

public class BinaryTransform {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution9 s= new Solution9();
		int num = s.NumberOf1(4);
		System.out.println(num);
	}

}

class Solution9 {
    public int NumberOf1(int n) {
        int num = 0;
        char[] b = Integer.toBinaryString(n).toCharArray();
        
        System.out.println(b);
        System.out.println(b.length);
        for(int i=0;i<b.length;i++){
            if(b[i]=='1'){
                num++;
            }
            System.out.println(b[i]);
        }
        return num;
    }
 
}