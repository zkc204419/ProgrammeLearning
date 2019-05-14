package kai.chang.zhang.Jian_Zhi_Offer;


public class ReConstructBinaryTree {
	public static TreeNode reConstructTree(int [] pre, int [] in) {
		TreeNode root = reConstructTree(pre, 0, pre.length-1, in, 0, in.length-1);
		return root;
	}
	public static void printTree(TreeNode root) {
		System.out.print(root.value);
		if(root.left!=null) {
			printTree(root.left);
		}
		if(root.right!=null) {
			printTree(root.right);
		}
	}
	private static TreeNode reConstructTree(int [] pre, int ps, int pe, int [] in, int is, int ie) {
		if(ps>pe || is > ie)
			return null;
		TreeNode root = new TreeNode(pre[ps]);
		for(int i = is; i <= ie; i++) {
			if(in[i] == pre[ps]) {
				root.left = reConstructTree(pre, ps+1,ps+1+i-is-1,in,is,i-1);
				root.right = reConstructTree(pre, ps+1+i-is-1+1, pe, in, i+1, ie);
			}
		}
		return root;
	}
	public static void main(String args[]) {
		int pre [] = new int [] {1,2,4,7,3,5,6,8};
		int in [] = new int [] {4,7,2,1,5,3,8,6};
		printTree(reConstructTree(pre, in));
	}
	

	
	
	
//
//	static class TreeNode{
//		TreeNode left;
//		TreeNode right;
//		int value;
//		public TreeNode(int value) {
//			this.value = value;
//		}
//	}
//	
//	public static TreeNode construct(int [] preOrder, int ps, int pe, int [] inOrder,int is,int ie) {
//		if(ps > pe || is > ie) {
//			return null;
//		}
//		int rootvalue = preOrder[ps];
//		int rootindex = is;
//		while(rootindex<=ie&& inOrder[rootindex]!=rootvalue) {
//			rootindex++;
//		}
//		System.out.println("当前各参数值为-> ps:" + ps + " pe:" + pe + " is:" + is + " ie:"+ ie
//				+ " rootindex:" + rootindex + " rootvalue:" + rootvalue);
//		TreeNode node = new TreeNode(rootvalue);
//		node.left = construct(preOrder, ps+1, ps+1+rootindex-is-1, inOrder, is, rootindex-1);
//		node.right = construct(preOrder, ps+1+rootindex-is-1+1, pe, inOrder, rootindex+1, ie);
//		return node;
//	}
//	
//	public static TreeNode reConstruct(int [] preOrder, int [] inOrder) {
//		return construct(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
//	}
//	
//	public static void printBinaryTree(TreeNode root) {
//		System.out.println(root.value);
//		while(root.left!=null)
//			printBinaryTree(root.left);
//		while(root.right!=null)
//			printBinaryTree(root.right);
//	}
//	
//
//	public static void main(String args[]) {
//		int preOrder[] = new int []{1,2,4,7,3,5,6,8};
//		int inOrder [] = new int []{4,7,2,1,5,3,6,8};
//		TreeNode root = reConstruct(preOrder, inOrder);
//		printBinaryTree(root);
//
//		
//		
//	}
//	
	
}
