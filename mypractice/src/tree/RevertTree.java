/** 
* Copyright 2016 Hushu Info Tech Co. Ltd.  All rights reserved.
* @author sun
* @date 2016-4-15 ÉÏÎç10:49:41 
* @version V1.0
*/
package tree;

public class RevertTree {

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
		
		System.out.println(countNode(testTree));
		
//		preTraversalTree(testTree);
//		
//		System.out.println();
//		midTraversalTree(testTree);
//		
//		System.out.println();
//		afterTraversalTree(testTree);
	}

	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
        	root.left = invertTree(root.left);
            root.right = invertTree(root.right);

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            return root;
        }
    }
    
    public static void preTraversalTree(TreeNode root){
    	if(root!=null){
    		System.out.print(root.val);
    		preTraversalTree(root.left);
    		preTraversalTree(root.right);
    	} else {
    		return ;
    	}
    }
    
    public static void midTraversalTree(TreeNode root){
    	if(root!=null){
    		midTraversalTree(root.left);
    		System.out.print(root.val);
    		midTraversalTree(root.right);
    	} else {
    		return ;
    	}
    }
    
    public static void afterTraversalTree(TreeNode root){
    	if(root!=null){
    		afterTraversalTree(root.left);
    		afterTraversalTree(root.right);
    		System.out.print(root.val);
    	} else {
    		return ;
    	}
    }
    
    public static int countNode(TreeNode root){
    	int sum = 0;
    	if(root!=null){
    		sum += 1;
    		sum += countNode(root.left);
    		sum += countNode(root.right);
    		return sum;
    	}else {
    		return 0;
    	}
    }
    
}
