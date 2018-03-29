package Trees;

/**
 * Created by Devaraj Reddy, 3/29/2018 - 10:54 PM
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
