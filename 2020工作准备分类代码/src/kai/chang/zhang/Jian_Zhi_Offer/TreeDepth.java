package kai.chang.zhang.Jian_Zhi_Offer;

//求从根结点到叶结点的最长路径，包括叶子结点和根结点
public class TreeDepth {
	
	public int treeDepth(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(treeDepth(root.left),treeDepth(root.right)) + 1;
	}
}

