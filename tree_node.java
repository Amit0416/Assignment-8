class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class tree_node {
    private static int index;

    public static TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        index = 0;
        return buildTree(s);
    }

    private static TreeNode buildTree(String s) {
        StringBuilder numBuilder = new StringBuilder();

        // Read the value of the current node
        while (index < s.length() && (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-')) {
            numBuilder.append(s.charAt(index));
            index++;
        }

        int val = Integer.parseInt(numBuilder.toString());
        TreeNode node = new TreeNode(val);

        // If there is a left child, recursively build the left subtree
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // Move past the opening parenthesis
            node.left = buildTree(s);
        }

        // If there is a right child, recursively build the right subtree
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // Move past the opening parenthesis
            node.right = buildTree(s);
        }

        index++; // Move past the closing parenthesis (or end of string)

        return node;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = str2tree(s);

        System.out.print("Inorder traversal: ");
        inorderTraversal(root);
    }
}
