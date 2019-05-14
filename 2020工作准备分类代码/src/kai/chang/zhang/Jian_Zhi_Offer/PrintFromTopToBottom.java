package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//��δ�ӡ��������������
//С�ģ�������Ϊ��ʱ�����Ӧ��Ϊ�յ�list������Ӧ����null
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
