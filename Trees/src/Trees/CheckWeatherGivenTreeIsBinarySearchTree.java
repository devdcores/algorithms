package Trees;

/**
 * Created by Devaraj Reddy, 3/31/2018 - 10:43 AM
 */
public class CheckWeatherGivenTreeIsBinarySearchTree {
    public static void main(String[] args) {


        TreeNode rootNode = new TreeNode(4);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(6);
        TreeNode fourthNode = new TreeNode(1);
        TreeNode fifthNode = new TreeNode(3);
        TreeNode sixthNode = new TreeNode(2);
        TreeNode seventhNode = new TreeNode(7);


        /*              4
         *             / \
         *            2   6
         * */
        rootNode.left = secondNode;
        rootNode.right = thirdNode;

        /*              2
         *             / \
         *            1   3
         * */
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;

        /*              6
         *             / \
         *            5   7
         * */
        thirdNode.left = sixthNode;
        thirdNode.right = seventhNode;

        /* Final tree from root
         *
         *              4
         *             / \
         *            3   6
         *           /\   /\
         *          1  2 5  7
         * */


        CheckIsItBSTree checkIsItBSTree = new CheckIsItBSTree(rootNode);

        System.out.println("<========> Weather given tree is binary search tree <========>");
        System.out.println("Is it binary tree : " + checkIsItBSTree.checkIsItBinaryTree());
        System.out.println("");


    }
}

class CheckIsItBSTree {
    TreeNode rootTreeNode;

    CheckIsItBSTree(TreeNode rootNode) {
        this.rootTreeNode = rootNode;
    }

    public boolean checkIsItBinaryTree() {
        return checkBinaryTree(rootTreeNode);
    }

    private boolean checkBinaryTree(TreeNode rootTreeNode) {
        if (rootTreeNode == null) {
            return true;
        }

        if (checkBinaryTreeLesser(rootTreeNode.left, rootTreeNode.data)
                && checkIsItBinaryTreeGreater(rootTreeNode.right, rootTreeNode.data)
                && checkBinaryTree(rootTreeNode.left)
                && checkBinaryTree(rootTreeNode.right)) {
            return true;
        }
        return false;
    }


    private boolean checkBinaryTreeLesser(TreeNode left, int data) {
        if (left == null) {
            return true;
        }
        if (left.data <= data) {
            return true;
        }
        return false;
    }

    private boolean checkIsItBinaryTreeGreater(TreeNode right, int data) {
        if (right == null) {
            return true;
        }
        if (right.data > data) {
            return true;
        }
        return false;
    }
}

