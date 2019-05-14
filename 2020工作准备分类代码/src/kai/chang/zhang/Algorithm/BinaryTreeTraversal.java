package kai.chang.zhang.Algorithm;

import java.util.LinkedList;
import java.util.Stack;

//二叉树遍历

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

	//先序遍历
	/*
	 *若二叉树为空则结束返回，否则：
	 *1、访问根结点
	 *2、先序遍历左子树
	 *3、先序遍历右子树。
	 *注意：遍历左右子树时，仍然采用先序遍历
	 */
	//先序递归实现
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
	//先序遍历非递归实现
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
	//中序遍历递归实现
	/*
	 * 若二叉树为空，则结束返回，否则：
	 * 1、中序遍历左子树
	 * 2、访问根节点
	 * 3、中序遍历右子树
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
	//中序遍历非递归实现
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
	
	//后序遍历
	/*
	 * 若二叉树为空则结束返回，否则：
	 * 1、后序遍历左子树
	 * 2、后序遍历右子树
	 * 3、访问根节点
	 */
	//首先要搞清楚先序、中序、后序的非递归算法的共同之处：用栈来保存之前走过的路径，
	/*
	 * 以便可以在访问完子树后，可以利用栈中的信息，回退到当前结点的父节点，进行下一步操作。
	 * 后序遍历的非递归算法是三种顺序中最复杂的，原因在于，后序遍历先是访问左子树、右子树
	 * 再访问根节点，而在非递归算法中，利用栈回退时，并不知道时从左子树还是从右子树回退到根节点
	 * 如果从左子树回退到根节点，此时就应该去访问右子树，而如果从右子树回退到根节点，此时就应该
	 * 访问根节点。所有相比前序和中序，必须在压栈时添加信息，以便在退栈时可以知道是从左子树返回，
	 * 还是从右子树返回，进而决定下一步的操作。
	 */
	//后序遍历递归实现
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
	
	//后序遍历非递归实现
	public static void postOrder(TreeNode biTree) {
		int left = 1;
		int right = 2;
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();//辅助栈，用来判断子结点返回父节点时，处于左结点还是右结点
		
		while(biTree!=null || !stack.isEmpty()) {
			while(biTree!=null) {
				//将结点压入栈1，并在栈2将结点标记为左结点
				stack.push(biTree);
				stack2.push(left);
				biTree = biTree.left;
			}
			while(!stack.isEmpty() && stack2.peek() == right) {
				//如果从右子节点返回父类，则任务完成，将两个栈顶弹出
				stack2.pop();
				System.out.println(stack.pop().value);
			}
			if(!stack.empty() && stack2.peek() == left) {
				//如果从左子结点返回父结点，则将标记改为右子结点。
				stack2.pop();
				stack2.push(right);
				biTree = stack.peek().right;
			}
		}
	}
	
	//层次遍历
	/*与树的前中后序遍历的DFS思想不同，层次遍历用到的是BFS思想。
	 * 一般DFS用递归去实现（也可以用栈实现），BFS需要用队列去实现。层次遍历的步骤是：   
	 *  1.对于不为空的结点，先把该结点加入到队列中    
	 *  2.从队中拿出结点，如果该结点的左右结点不为空，就分别把左右结点加入到队列中    
	 *  3.重复以上操作直到队列为空
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



















