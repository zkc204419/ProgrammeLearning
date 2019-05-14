package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.ArrayList;

public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k) {
        ArrayList<ListNode> list= new ArrayList<>();
		while(head!=null) {
			list.add(head);
			head = head.next;
		}
        if(k > list.size() || k <= 0 || list.size() == 0)
			return null;
		return list.get(list.size()-k);
    }
	
}
