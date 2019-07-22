package algorithm.nowcoder;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 
 *     1  2  3  4 
 *     5  6  7  8 
 *     9  10 11 12 
 *     13 14 15 16 
 * 则依次打印出数字 : 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 测试用例：[[1],[2],[3],[4]]      [[1]]
 * 输出：       [1,2,3,4]              [1]
 * @author Administrator
 */
public class OutputCircleMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,5},{2,6},{3,7},{4,8}};
		OutputCircleMatrix ocm = new OutputCircleMatrix();
		ArrayList<Integer> list = ocm.printMatrix(matrix);
		System.out.println(list.toString());
	}
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int row = matrix.length;     //得到矩阵的行
		int col = matrix[0].length;  //得到矩阵的列
		int left = 0,top = 0,right = col-1,buttom = row-1;
		while(left<=right && top<=buttom){
			//最上的从左到右打印
			for(int i=left;i<=right;i++) {
				list.add(matrix[top][i]);
				}
			top++;  
			
			//最右的从上往下打印
			for(int i=top;i<=buttom;i++) {
				list.add(matrix[i][right]);
				}
			right--;	
						
			//最下的从右往左打印
			if(top<=buttom)  //主要避免只有一行的时候从左往右打印后，又重复从右往左打印
			for(int i=right;i>=left;i--) {
				list.add(matrix[buttom][i]);
				}
			buttom--;
			
			//最左的从下往上打印(最后一行避免打印到top行重复，因此打印到top+1行[上面已经top++了，如果没有，则需要考虑])
			if(left<=right)    //对于只有一列的,right=1-1=0,从上往下打印后，right=-1<left,对于两列的,right=2-1=1,打印后right-1=0==left
			for(int i=buttom;i>=top;i--) {   //因此left<=right的时候才需要从下往上打印，只有一列的时候就不需要了
				list.add(matrix[i][left]);
			}			
			left++;
		}
		return list;	       
    }
}
