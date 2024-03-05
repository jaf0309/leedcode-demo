package cn.self.leedcode.TwoTree;


public class Two06 {

    private static ListNode temp = new ListNode();

    public static ListNode reverseList(ListNode head) {
        reverse( head);
        return temp;

    }
    public static void reverse(ListNode head) {
        if(head == null){
            return;
        }
        System.out.println(head.getVal());
        reverse(head.getNext());



    }

    public static ListNode reverseList2(ListNode head) {
        // 递归反转链表
        if (head == null|| head.getNext()==null){
            return head;
        }
        ListNode last = reverseList2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return last;
    }


    public static void main(String[] args) {
        ListNode treeNode7 = new ListNode(7);
        ListNode treeNode6 = new ListNode(6,treeNode7);
        ListNode treeNode5 = new ListNode(5,treeNode6);
        ListNode treeNode4 = new ListNode(4,treeNode5);
        ListNode treeNode3 = new ListNode(3,treeNode4);
        ListNode treeNode2 = new ListNode(2,treeNode3);
        ListNode treeNode1 = new ListNode(1,treeNode2);

        reverse(reverseList2(treeNode1));
    }

}