package cn.self.leedcode.TwoTree.twosearch;

import cn.self.leedcode.TwoTree.TreeNode;

public class Four50 {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        deleteNodeByKey(root,root.getLeft(),key);
        deleteNodeByKey(root,root.getRight(),key);
        return root;
    }

    public static void deleteNodeByKey(TreeNode father,TreeNode sun, int key){
        if(father == null){
            return;
        }
        if(father.getVal() == key){
            father = new TreeNode();
            return;
        }
        if(sun == null){
            return;
        }
        //子节点在左边
        if(sun.getVal() == key && father.getLeft() == sun){
            if(sun.getLeft() != null && sun.getLeft() != null){
                father.setLeft(sun.getRight());
                father.getLeft().setLeft(sun.getLeft());
            }else if(sun.getRight() == null && sun.getLeft() == null){
                father.setLeft(null);
            }else if(sun.getRight() != null && sun.getLeft() == null){
                father.setLeft(sun.getRight()) ;
            }else if(sun.getRight() == null && sun.getLeft() != null){
                father.setLeft(sun.getLeft());
            }
            //子节点在右边
        }else if (sun.getVal() == key && father.getRight() == sun){
            if(sun.getRight() != null && sun.getLeft() != null){
                father.setRight(sun.getRight());
                father.getRight().setLeft(sun.getLeft());
            }else if(sun.getRight() == null && sun.getLeft() == null){
                father.setRight(null) ;
            }else if(sun.getRight() != null && sun.getLeft() == null){
                father.setRight(sun.getRight()) ;
            }else if(sun.getRight() == null && sun.getLeft() != null){
                father.setRight(sun.getLeft());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new TreeNode().getVal());
        TreeNode treeNode = new TreeNode(0);
        System.out.println(deleteNode(treeNode, 0).getVal());
    }
}