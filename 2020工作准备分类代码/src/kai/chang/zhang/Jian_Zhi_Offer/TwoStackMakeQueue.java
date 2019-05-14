package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.Stack;

public class TwoStackMakeQueue {
	
	Stack<Integer>stack1 = new Stack<>();
	Stack<Integer>stack2 = new Stack<>();
	
	public void push(int node) {
		while(!stack2.empty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(node);
	}
	public void pop() {
		while(!stack1.empty()) {
			stack2.push(stack1.pop());
		}
		stack2.pop();
	}
		
}
