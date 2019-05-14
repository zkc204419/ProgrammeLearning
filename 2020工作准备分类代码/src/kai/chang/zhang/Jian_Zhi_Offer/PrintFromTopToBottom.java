package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//层次打印二叉树，从左到右
//小心，当输入为空时，输出应该为空的list。而不应该是null
public class PrintFromTopToBottom {
	
	public ArrayList<Integer> printFromTopBottom(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		Queue<TreeNode>queue = new LinkedList<>();
		if(root == null ) {
			return list;
		}
		else {
			queue.add(root);
			while(!queue.isEmpty()) {
				root = queue.poll();
				list.add(root.value);
				if(root.left!=null) {
					queue.add(root.left);
				}
				if(root.right!=null) {
					queue.add(root.right);
				}
			}
		}
		return list;
	}
}
