package kai.chang.zhang.Algorithm;

import java.util.LinkedList;
import java.util.Stack;

//����������

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int value) {
		this.value = value;
	}
}

public class BinaryTreeTraversal {
	
	public static void main(String args[]) {
		TreeNode [] node = new TreeNode[10];
		for(int i = 0, len = node.length; i < len; i++) {
			node[i] = new TreeNode(i);
		}
		for(int i = 0; i < 10; i++) {
			if(i*2+1<10)
				node[i].left = node[i*2+1];
			if(i*2+2<10)
				node[i].right = node[i*2+2];
		}
		levelOrder(node[0]);
	}

	//�������
	/*
	 *��������Ϊ����������أ�����
	 *1�����ʸ����
	 *2���������������
	 *3�����������������
	 *ע�⣺������������ʱ����Ȼ�����������
	 */
	//����ݹ�ʵ��
	public static void preOrderRe(TreeNode biTree) {
		System.out.print(biTree.value);
		TreeNode leftTree = biTree.left;
		if(leftTree!=null) {
			preOrderRe(leftTree);
		}
		TreeNode rightTree = biTree.right;
		if(rightTree!=null) {
			preOrderRe(rightTree);
		}
	}
	//��������ǵݹ�ʵ��
	public static void preOrder( TreeNode biTree) {
		Stack<TreeNode> stack = new Stack<>();
		while(biTree != null || !stack.isEmpty()) {
			while(biTree!=null) {
				System.out.print(biTree.value);
				stack.push(biTree);
				biTree = biTree.left;
			}
			if(!stack.isEmpty()) {
				biTree = stack.pop();
				biTree = biTree.right;
			}
		}
	}
	//��������ݹ�ʵ��
	/*
	 * ��������Ϊ�գ���������أ�����
	 * 1���������������
	 * 2�����ʸ��ڵ�
	 * 3���������������
	 */
	
	public static void midOrderRe(TreeNode biTree) {
		if(biTree == null)
			return ;
		else {
			midOrderRe(biTree.left);
			System.out.print(biTree.value);
			midOrderRe(biTree.right);
		}
	}
	//��������ǵݹ�ʵ��
	public static void midOrder(TreeNode biTree) {
		Stack<TreeNode>stack = new Stack<>();
		while(biTree!=null || !stack.isEmpty()) {
			while(biTree!=null) {
				stack.push(biTree);
				biTree = biTree.left;
			}
			if(!stack.isEmpty()) {
				biTree = stack.pop();
				System.out.print(biTree.value);
				biTree = biTree.right;
			}
		}
	}
	
	//�������
	/*
	 * ��������Ϊ����������أ�����
	 * 1���������������
	 * 2���������������
	 * 3�����ʸ��ڵ�
	 */
	//����Ҫ������������򡢺���ķǵݹ��㷨�Ĺ�֮ͬ������ջ������֮ǰ�߹���·����
	/*
	 * �Ա�����ڷ����������󣬿�������ջ�е���Ϣ�����˵���ǰ���ĸ��ڵ㣬������һ��������
	 * ��������ķǵݹ��㷨������˳������ӵģ�ԭ�����ڣ�����������Ƿ�����������������
	 * �ٷ��ʸ��ڵ㣬���ڷǵݹ��㷨�У�����ջ����ʱ������֪��ʱ�����������Ǵ����������˵����ڵ�
	 * ��������������˵����ڵ㣬��ʱ��Ӧ��ȥ����������������������������˵����ڵ㣬��ʱ��Ӧ��
	 * ���ʸ��ڵ㡣�������ǰ������򣬱�����ѹջʱ�����Ϣ���Ա�����ջʱ����֪���Ǵ����������أ�
	 * ���Ǵ����������أ�����������һ���Ĳ�����
	 */
	//��������ݹ�ʵ��
	public static void postOrderRe(TreeNode biTree) {
		if(biTree == null) {
			return ;
		}
		else {
			postOrderRe(biTree.left);
			postOrderRe(biTree.right);
			System.out.println(biTree.value);
		}
	}
	
	//��������ǵݹ�ʵ��
	public static void postOrder(TreeNode biTree) {
		int left = 1;
		int right = 2;
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();//����ջ�������ж��ӽ�㷵�ظ��ڵ�ʱ���������㻹���ҽ��
		
		while(biTree!=null || !stack.isEmpty()) {
			while(biTree!=null) {
				//�����ѹ��ջ1������ջ2�������Ϊ����
				stack.push(biTree);
				stack2.push(left);
				biTree = biTree.left;
			}
			while(!stack.isEmpty() && stack2.peek() == right) {
				//��������ӽڵ㷵�ظ��࣬��������ɣ�������ջ������
				stack2.pop();
				System.out.println(stack.pop().value);
			}
			if(!stack.empty() && stack2.peek() == left) {
				//��������ӽ�㷵�ظ���㣬�򽫱�Ǹ�Ϊ���ӽ�㡣
				stack2.pop();
				stack2.push(right);
				biTree = stack.peek().right;
			}
		}
	}
	
	//��α���
	/*������ǰ�к��������DFS˼�벻ͬ����α����õ�����BFS˼�롣
	 * һ��DFS�õݹ�ȥʵ�֣�Ҳ������ջʵ�֣���BFS��Ҫ�ö���ȥʵ�֡���α����Ĳ����ǣ�   
	 *  1.���ڲ�Ϊ�յĽ�㣬�ȰѸý����뵽������    
	 *  2.�Ӷ����ó���㣬����ý������ҽ�㲻Ϊ�գ��ͷֱ�����ҽ����뵽������    
	 *  3.�ظ����ϲ���ֱ������Ϊ��
	 */
	public static void levelOrder(TreeNode biTree) {
		if(biTree == null)
			return;
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(biTree);
		TreeNode currentNode;
		while(!list.isEmpty()) {
			currentNode = list.poll();
			System.out.println(currentNode.value);
			if(currentNode.left!=null)
				list.add(currentNode.left);
			if(currentNode.right!=null)
				list.add(currentNode.right);
		}
	}
}



















