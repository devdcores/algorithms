package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Devaraj Reddy, 3/31/2018 - 6:02 PM
 */
public class BinaryTreeOperations {
    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(3);
        TreeNode fourthNode = new TreeNode(4);
        TreeNode fifthNode = new TreeNode(5);
        TreeNode sixthNode = new TreeNode(6);
        TreeNode seventhNode = new TreeNode(7);


        /*              1
         *             / \
         *            2   3
         * */
        rootNode.left = secondNode;
        rootNode.right = thirdNode;

        /*              2
         *             / \
         *            4   5
         * */
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;

        /*              3
         *             / \
         *            6   7
         * */
        thirdNode.left = sixthNode;
        thirdNode.right = seventhNode;

        /* Final tree from root
         *
         *              1
         *             / \
         *            2   3
         *           /\   /\
         *          4  5 6  7
         * */

        BinaryTree binaryTree = new BinaryTree(rootNode);
        System.out.println("<========> InOrder Traversal Recursive <========>");
        System.out.println("Max Value Using Recursion: " + binaryTree.findMax());
        System.out.println("");


        System.out.println("<========> InOrder Traversal Recursive <========>");
        System.out.println("Max Value Using Iterative (level order traversal) : " + binaryTree.findMaxIterative());
        System.out.println("");


        System.out.println("Size of the tree : "+binaryTree.sizeOfTree());

    }
}

class BinaryTree {

    TreeNode rootTreeNode;

    BinaryTree(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }


    public int findMax() {
        return findMaxRecursively(rootTreeNode);
    }

    /*
     *
     * find the max of leftsubtree and rightsubtree, compare that with root data. and return max value.
     *
     * */
    private int findMaxRecursively(TreeNode rootTreeNode) {
        int maxValue = Integer.MIN_VALUE;
        if (rootTreeNode != null) {
            int leftMax = findMaxRecursively(rootTreeNode.left);
            int rightMax = findMaxRecursively(rootTreeNode.right);

            if (leftMax > rightMax) {
                maxValue = leftMax;
            } else {
                maxValue = rightMax;
            }

            if (rootTreeNode.data > maxValue) {
                maxValue = rootTreeNode.data;
            }
        }
        return maxValue;
    }

    /*
     *
     * Do level order any any order traversal iterative, compare the data with max. return max.
     *
     * */
    public Integer findMaxIterative() {
        Integer max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (rootTreeNode != null) {
            queue.add(rootTreeNode);
        }
        while (!queue.isEmpty()) {
            TreeNode polledTreeNode = queue.poll();
            if (polledTreeNode != null) {
                if (polledTreeNode.data > max) {
                    max = polledTreeNode.data;
                }

                if (polledTreeNode.left != null) {
                    queue.add(polledTreeNode.left);
                }
                if (polledTreeNode.right != null) {
                    queue.add(polledTreeNode.right);
                }
            }


        }
        return max;
    }

    public int sizeOfTree() {
        return sizeOfTreeRecursively(rootTreeNode);
    }

    private int sizeOfTreeRecursively(TreeNode rootTreeNode) {
        if (rootTreeNode == null) {
            return 0;
        }
        int leftSize = sizeOfTreeRecursively(rootTreeNode.left);
        int rightSize = sizeOfTreeRecursively(rootTreeNode.right);
        return leftSize + rightSize + 1;
    }
}
