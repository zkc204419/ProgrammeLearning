package kai.chang.zhang.Algorithm;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;



class ImmutableClass{
	private Date date;
	
	public ImmutableClass(Date d) {
		this.date = d;
	}
	
	public void printState() {
		System.out.println(date);
	}
}

public class Test2 {
	public static void main(String args[]) {
		int i = -1;
		System.out.println(" ----int>>:" + i);
		System.out.println("��λǰ�����ƣ�" + Integer.toBinaryString(i));
		i>>=2;
		System.out.println("��λ������ƣ�" + Integer.toBinaryString(i));
		
		i = 4;
		System.out.println(" ----int>>:" + i);
		System.out.println("��λǰ�����ƣ�" + Integer.toBinaryString(i));
		i>>=2;
		System.out.println("��λ������ƣ�" + Integer.toBinaryString(i));
		
		short j = -4;
		System.out.println(" ----short>>:" + j);
		System.out.println("��λǰ�����ƣ�" + Integer.toBinaryString(j));
		j>>=2;
		System.out.println("��λ������ƣ�" + Integer.toBinaryString(j));
	}
}














































