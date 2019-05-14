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
		System.out.println("移位前二进制：" + Integer.toBinaryString(i));
		i>>=2;
		System.out.println("移位后二进制：" + Integer.toBinaryString(i));
		
		i = 4;
		System.out.println(" ----int>>:" + i);
		System.out.println("移位前二进制：" + Integer.toBinaryString(i));
		i>>=2;
		System.out.println("移位后二进制：" + Integer.toBinaryString(i));
		
		short j = -4;
		System.out.println(" ----short>>:" + j);
		System.out.println("移位前二进制：" + Integer.toBinaryString(j));
		j>>=2;
		System.out.println("移位后二进制：" + Integer.toBinaryString(j));
	}
}














































