package kai.chang.zhang.Jian_Zhi_Offer;

//��Ӹ���㵽Ҷ�����·��������Ҷ�ӽ��͸����
public class TreeDepth {
	
	public int treeDepth(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(treeDepth(root.left),treeDepth(root.right)) + 1;
	}
}

