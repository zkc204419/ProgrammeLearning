package kai.chang.zhang.Jian_Zhi_Offer;


//剪绳子
public class CuttingRope {
	//动态规划
	public int maxProductAfterCutting(int length) {
		if(length <=1)
			return 0;
		if(length == 2) 
			return 1;
		if(length == 3)
			return 2;
		//用于存储length=i，切割后乘机最大值保存在reuslt[i]内
		int result[] = new int [length+1]; 
		/*
		 * 以下初始化值为当length>3时，进行一个分割产生的最大值，
		 * 此时不许再分割，例如length=5，分割后为3和2此时3*2为最大
		 * 值，不用再分割。
		 */
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		for(int i = 4; i <= length; i++) {
			int max = 0;
			for(int j = 1; j <= i/2; j++) {
				int num = result[i]*result[i-j];
				if(num > max) {
					max = num;
				}
			}
			result[i] = max;
		}
		return result[length];
	}
		
}




















