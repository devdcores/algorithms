package Trees;

import javax.xml.soap.Node;

/**
 * Created by Devaraj Reddy, 3/29/2018 - 11:10 PM
 */
public class BSTree {
    TreeNode rootTreeNode;

    public BSTree() {

    }

    public BSTree(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }

    public void insert(int data) {

        rootTreeNode = insertNode(rootTreeNode, data);
        TreeNode treeNode = new TreeNode(data);
        if (rootTreeNode == null) {
            rootTreeNode = treeNode;
        }
    }

    private TreeNode insertNode(TreeNode rootTreeNode, int data) {
        if (rootTreeNode == null) {
            rootTreeNode = new TreeNode(data);
            return rootTreeNode;
        }
        if (data < rootTreeNode.data) {
            rootTreeNode.left = insertNode(rootTreeNode.left, data);
        } else {
            rootTreeNode.right = insertNode(rootTreeNode.right, data);
        }
        return rootTreeNode;
    }

    public void inOrderTraversal(){
        inOrder(rootTreeNode);
    }

    private void inOrder(TreeNode rootTreeNode) {
        if(rootTreeNode!=null){
            inOrder(rootTreeNode.left);
            System.out.println("data : "+rootTreeNode.data);
            inOrder(rootTreeNode.right);
        }
    }


    public TreeNode search(int data) {
       return searchNode(rootTreeNode,data);
    }

    private TreeNode searchNode(TreeNode rootNode, int data) {
        if(rootNode==null){
            return null;
        }
        if(rootNode.data==data){
            return rootNode;
        }
        if(data<rootNode.data) {
            return searchNode(rootNode.left, data);
        }
        return searchNode(rootNode.right,data);
    }

    public TreeNode findMinimumRecursive() {
        return findMin(rootTreeNode);
    }

    private TreeNode findMin(TreeNode rootTreeNode) {
        if(rootTreeNode.left==null){
            return rootTreeNode;
        }
        return findMin(rootTreeNode.left);
    }

    public TreeNode findMinimumIterative() {
        TreeNode tempNode = rootTreeNode;
        if(tempNode==null){
            return null;
        }
        while(tempNode.left!=null){
            tempNode=tempNode.left;
        }
        return tempNode;
    }

    public TreeNode findMaximumRecursive() {
        return findMax(rootTreeNode);
    }

    private TreeNode findMax(TreeNode rootTreeNode) {
        if(rootTreeNode.right==null){
            return rootTreeNode;
        }
        return findMax(rootTreeNode.right);
    }

    public TreeNode findMaximumIterative() {

        TreeNode tempNode = rootTreeNode;
        if(tempNode==null){
            return null;
        }
        while(tempNode.right!=null){
            tempNode=tempNode.right;
        }
        return tempNode;
    }

    public int findHeight() {
       return height(rootTreeNode);
    }

    private int height(TreeNode rootTreeNode) {
        if(rootTreeNode==null){
            return -1;
        }
        int leftHeight=height(rootTreeNode.left);
        int rightHeight=height(rootTreeNode.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}

class BSTreeMain {
    public static void main(String[] args) {

         /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        BSTree bsTree = new BSTree();
        bsTree.insert(50);
        bsTree.insert(30);
        bsTree.insert(20);
        bsTree.insert(40);
        bsTree.insert(70);
        bsTree.insert(60);
        bsTree.insert(80);

        bsTree.inOrderTraversal();

        System.out.println("Found : "+bsTree.search(50));

        //Recursive min
        System.out.println("Minimum value in tree using recursion: "+bsTree.findMinimumRecursive());
        //Iterative min
        System.out.println("Minimum value in tree using iterative: "+bsTree.findMinimumIterative());

        //Recursive min
        System.out.println("Maximum value in tree using recursion: "+bsTree.findMaximumRecursive());
        //Iterative min
        System.out.println("Maximum value in tree using iterative: "+bsTree.findMaximumIterative());

        System.out.println("Height of the tree: "+bsTree.findHeight());



    }
}
