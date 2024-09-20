import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static class TreeNode {
        int n;
        TreeNode left;
        TreeNode right;
        public TreeNode(int n) {
            this(n , null, null);
        }
        public TreeNode(int n, TreeNode left, TreeNode right) {
            this.n = n;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return n + "";
        }
    }
    private TreeNode root;

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.n + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public void postorder(TreeNode root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.n + " ");
    }
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.n + " ");
        inorder(root.right);
    }
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            System.out.print(current.n + ", ");
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode six = new TreeNode(6);
        TreeNode nine  = new TreeNode(9);
        tree.root.left = two;
        tree.root.right = nine;
        nine.left = six;
        nine.right = eleven;
        eleven.left = ten;
        System.out.print("Pre Order: ");
        tree.preorder(tree.root);
        System.out.println();
        System.out.print("Post Order: ");
        tree.postorder(tree.root);
        System.out.println();
        System.out.print("In Order: ");
        tree.inorder(tree.root);
        System.out.println();
        System.out.print("Level Order: ");
        tree.levelOrder(tree.root);
    }
}