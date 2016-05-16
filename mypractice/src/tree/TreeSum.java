package tree;

public class TreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode testTree = new TreeNode("a",1);
		testTree.left = new TreeNode("b",2);
		testTree.right = new TreeNode("c",3);
		testTree.left.left = new TreeNode("d",4);
		testTree.left.left.right = new TreeNode("e",5);
		testTree.left.right = new TreeNode("f",6);
		testTree.left.right.left = new TreeNode("g",7);
		int sum = preTraversalTree(testTree);
		System.out.println();
		System.out.println(sum);
	}
	
	public static int preTraversalTree(TreeNode root){
		int sum = 0;
    	if(root!=null){
    		System.out.print(root.val1);
    		sum += root.val1;
    		sum += preTraversalTree(root.left);
    		sum += preTraversalTree(root.right);
    		return sum;
    	} else {
    		return sum;
    	}
    }

}
