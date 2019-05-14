package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.Stack;
public class ReverseList {
	public ListNode reverseList(ListNode head) {

		if(head==null) {
			return null;
		}
		Stack<ListNode>stack = new Stack<>();
		while(head!=null) {
			stack.push(head);
			head = head.next;
		}
		head = stack.pop();
		ListNode temp = head;
		while(!stack.empty()) {
			head.next = stack.pop();
			head = head.next;
		}
		head.next = null;
		return temp;
	}
}
