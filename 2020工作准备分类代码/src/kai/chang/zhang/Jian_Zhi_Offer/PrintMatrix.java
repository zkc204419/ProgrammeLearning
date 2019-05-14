package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintMatrix {

	public  ArrayList<Integer> printMatrix(int [][] matrix){
		ArrayList<Integer>list = new ArrayList<>();
		int m = matrix.length;
		int n = matrix[0].length;
		boolean flag[][] = new boolean [m][n];
		for(int i = 0; i < m; i++) {
			Arrays.fill(flag[i], false);
		}
		int i = 0,j = 0,temp = matrix[0][0];
		flag[0][0] = true;
		list.add(temp);
		boolean flag_w = true;
		int count = 1;
		int max = m * n; 
		if(max == 1) {
			return list;
		}
		while(flag_w) {
			while(j+1<n &&flag[i][j+1]== false ) {
				list.add(matrix[i][j+1]);
				flag[i][j+1] = true;
				j++;
				count++;
				if(count == max) {
					flag_w = false;
					break;
				}
			}
			while( i + 1< m &&flag[i+1][j] == false ) {
				list.add(matrix[i+1][j]);
				flag[i+1][j] = true;
				i++;
				count++;
				if(count == max) {
					flag_w = false;
					break;
				}
				
			}
			while(j-1>=0 && flag[i][j-1] == false) {
				list.add(matrix[i][j-1]);
				flag[i][j-1] = true;
				j--;
				count++;
				if(count == max) {
					flag_w = false;
					break;
				}
			}
			while(i-1 >=0 && flag[i-1][j] ==false) {
				list.add(matrix[i-1][j]);
				flag[i-1][j] = true;
				i--;
				count++;
				if(count == max) {
					flag_w = false;
					break;
				}
			}
		}
		return list;
	}
	
}
