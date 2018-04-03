package Trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Devaraj Reddy, 3/31/2018 - 11:49 AM
 */
public class BinaryTreeTraversalsMain {
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

        BinaryTreeTraversals binaryTreeTraversals = new BinaryTreeTraversals(rootNode);

        System.out.println("<========> InOrder Traversal Recursive <========>");
        binaryTreeTraversals.inOrderTraversalRecursive();
        System.out.println("");

        System.out.println("<========> PreOrder Traversal Recursive <========>");
        binaryTreeTraversals.preOrderTraversalRecursive();
        System.out.println("");

        System.out.println("<========> PostOrder Traversal Recursive <========>");
        binaryTreeTraversals.postOrderTraversalRecursive();
        System.out.println("");

        System.out.println("");
        System.out.println("#############################################################################################################################");
        System.out.println("");

        System.out.println("<========> InOrder Traversal Iterative <========>");
        binaryTreeTraversals.inOrderTraversalIterative();
        System.out.println("");

        System.out.println("<========> PreOrder Traversal Iterative <========>");
        binaryTreeTraversals.preOrderTraversalIterative();
        System.out.println("");

        System.out.println("<========> PostOrder Traversal Iterative <========>");
        binaryTreeTraversals.postOrderTraversalIterative();
        System.out.println("");

        System.out.println("<========> Level Order Traversal <========>");
        binaryTreeTraversals.levelOrderTraversal();
        System.out.println("");

        System.out.println("<========> Level Order Traversal in Reverse <========>");
        binaryTreeTraversals.levelOrderTraversalInReverse();
        System.out.println("");

    }
}

class BinaryTreeTraversals {
    TreeNode rootTreeNode;

    BinaryTreeTraversals(TreeNode rootNode) {
        this.rootTreeNode = rootNode;
    }


    public void inOrderTraversalRecursive() {
        inOrderRecursive(rootTreeNode);
    }

    private void inOrderRecursive(TreeNode rootTreeNode) {
        if (rootTreeNode != null) {
            inOrderRecursive(rootTreeNode.left);
            System.out.print(rootTreeNode.data + ", ");
            inOrderRecursive(rootTreeNode.right);
        }
    }

    public void preOrderTraversalRecursive() {
        preOrderRecursive(rootTreeNode);
    }

    private void preOrderRecursive(TreeNode rootTreeNode) {
        if (rootTreeNode != null) {
            System.out.print(rootTreeNode.data + ", ");
            preOrderRecursive(rootTreeNode.left);
            preOrderRecursive(rootTreeNode.right);
        }
    }

    public void postOrderTraversalRecursive() {
        postOrderRecursive(rootTreeNode);
    }

    private void postOrderRecursive(TreeNode rootTreeNode) {
        if (rootTreeNode != null) {
            postOrderRecursive(rootTreeNode.left);
            postOrderRecursive(rootTreeNode.right);
            System.out.print(rootTreeNode.data + ", ");
        }
    }

    public void inOrderTraversalIterative() {
        Stack<TreeNode> stack = new Stack<>();
        if (rootTreeNode == null) {
            return;
        }
        TreeNode currentNode = rootTreeNode;
        while (true) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    TreeNode pop = stack.pop();
                    System.out.print(pop.data + ", ");
                    currentNode = pop.right;
                }
            }
        }
    }

    public void preOrderTraversalIterative() {
        Stack<TreeNode> stack = new Stack<>();
        if (rootTreeNode == null) {
            return;
        }
        stack.push(rootTreeNode);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.data + ", ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public void postOrderTraversalIterative() {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        if (rootTreeNode == null) {
            return;
        }
        s1.push(rootTreeNode);
        while (!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            s2.push(pop);
            if (pop.left != null) {
                s1.push(pop.left);
            }
            if (pop.right != null) {
                s1.push(pop.right);
            }
        }

        while (!s2.empty()) {
            TreeNode pop = s2.pop();
            System.out.print(pop.data + ", ");
        }

    }

    public void levelOrderTraversal() {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (rootTreeNode != null) {
            queue.add(rootTreeNode);
        }
        while (!queue.isEmpty()) {
            TreeNode polledTreeNode = queue.poll();
            if (polledTreeNode != null) {
                System.out.print(polledTreeNode.data + ", ");

                if (polledTreeNode.left != null) {
                    queue.add(polledTreeNode.left);
                }
                if (polledTreeNode.right != null) {
                    queue.add(polledTreeNode.right);
                }
            }
        }

    }

    /*
    * output should be 4 5 6 7 3 2 1
    * level by level reverse.
    *
    * */
    public void levelOrderTraversalInReverse() {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (rootTreeNode != null) {
            queue.add(rootTreeNode);
        }
        while (!queue.isEmpty()) {
            TreeNode polledTreeNode = queue.poll();
            if (polledTreeNode != null) {
                if (polledTreeNode.right != null) {
                    queue.add(polledTreeNode.right);
                }

                if (polledTreeNode.left != null) {
                    queue.add(polledTreeNode.left);
                }
                stack.push(polledTreeNode);
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop().data+", ");
        }

    }
}

