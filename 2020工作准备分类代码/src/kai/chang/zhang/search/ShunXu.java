package kai.chang.zhang.search;


//顺序查找算法
//针对少量，无规则的数据
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
