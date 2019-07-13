package algorithm.nowcoder;

import java.io.EOFException;

public class PowerCalc {

	/**给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
	 * @param args
	 */
	public static void main(String[] args) {
		Solution10 s = new Solution10();
		double r = s.Power(2,-3);
		System.out.println(r);

	}

}

class Solution10 {
    public double Power(double base, int exponent) {
    	double result = 1;
    	boolean flag = true;
    	if(exponent<0){
    		exponent = -exponent;
    		flag = false;
    	}
    	while(exponent-->0){
    		result = result*base;
    	}
    	if(flag)
    		return result;
    	return 1/result;
  }
}