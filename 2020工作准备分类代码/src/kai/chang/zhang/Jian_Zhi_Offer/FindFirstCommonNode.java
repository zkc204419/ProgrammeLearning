package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

public class FindFirstCommonNode {
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null && pHead2 == null)
			return pHead1;
		while(pHead1!=null) {
			ListNode pHead2_temp = pHead2;
			while(pHead2!=null) {
				if(pHead1.val == pHead2.val)
					return pHead1;
				pHead2 = pHead2.next;
			}
			pHead1 = pHead1.next;
			pHead2 = pHead2_temp;
		}
		return null;
	}
	
	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null & pHead2 == null) {
			return null;
		}
		Stack<ListNode>stack_1 = new Stack<>();
		Stack<ListNode>stack_2 = new Stack<>();
		while(pHead1!=null || pHead2!=null) {
			while(pHead1!=null) {
				stack_1.push(pHead1);
				pHead1 = pHead1.next;
			}
			while(pHead2!=null) {
				stack_2.push(pHead2);
				pHead2 = pHead2.next;
			}
		}
		ListNode temp_1,temp_2,result=null;
		while(!stack_1.empty() && !stack_2.empty()) {
			if((temp_1 =stack_1.pop()) == (temp_2=stack_2.pop())) {
				result = temp_1;
				continue;
			}
		}
		return result;
	}
	
}
