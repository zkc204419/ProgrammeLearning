package kai.chang.zhang.search;


//˳������㷨
//����������޹��������
public class ShunXu {
	public boolean shunxu(int a [], int x ) {
		for(int i = 0; i < a.length ; i++) {
			if(a[i] == x) {
				return true;
			}
		}
		return false;
	}
}
