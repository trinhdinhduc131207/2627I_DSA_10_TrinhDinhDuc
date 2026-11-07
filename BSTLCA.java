public class BSTLCA {
    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        // Nếu cả v1 và v2 nhỏ hơn giá trị root -> LCA nằm ở nhánh trái
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        // Nếu cả v1 và v2 lớn hơn giá trị root -> LCA nằm ở nhánh phải
        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        // Nút hiện tại chính là Tổ tiên chung gần nhất (LCA)
        return root;
    }
}
