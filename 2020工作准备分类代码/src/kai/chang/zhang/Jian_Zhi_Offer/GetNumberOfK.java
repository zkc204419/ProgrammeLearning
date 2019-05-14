package kai.chang.zhang.Jian_Zhi_Offer;


public class GetNumberOfK {
	public int getNumberOfK(int [] array, int k) {
		int s_index = binarySearch(array, k, 0);
		int e_index = binarySearch(array, k, 1);
		if(s_index == -1 &&  e_index == -1) {
			return 0;
		}
		int result = e_index - s_index + 1;
		return result;
	}
	
	public int binarySearch(int [] array, int k, int flag) {
		int start = 0;
		int end = array.length-1;
		int mid = (start + end) / 2;
		int resultindex = -1;
		while(start <= end) {
			int temp = array[mid];
			if(temp == k) {
				resultindex = mid;
				if(flag == 0)
					end = mid -1;
				else if(flag == 1) {
					start = mid + 1;
				}
			}
			else if(temp > k) {
				end = mid -1; 
			}
			else {
				start = mid + 1;
			}
			mid = (start + end)/2;
		}
		return resultindex;
	}
	
}
