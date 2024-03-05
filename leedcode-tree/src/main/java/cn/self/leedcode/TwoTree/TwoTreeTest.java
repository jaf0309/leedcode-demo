package cn.self.leedcode.TwoTree;


public class TwoTreeTest {
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2,treeNode3,treeNode4);
        TreeNode treeNode5 = new TreeNode(5,treeNode6,treeNode7);
        TreeNode treeNode1 = new TreeNode(1,treeNode2,treeNode5);
        PrintBinaryTreeBacRecur(treeNode1);


    }


    public static void PrintBinaryTreeBacRecur(TreeNode root){
        if (root == null) {
            return;
        }
        //System.out.println("前续遍历结果："+root.getVal());

        //System.out.println("中续遍历结果："+root.getVal());

        PrintBinaryTreeBacRecur(root.getLeft());
        PrintBinaryTreeBacRecur(root.getRight());
        System.out.println("后续遍历结果："+root.getVal());

    }


}