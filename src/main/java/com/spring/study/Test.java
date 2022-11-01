package com.spring.study;

public class Test {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        ListNode test1 = new ListNode(2);
        ListNode test2 = new ListNode(3);
        ListNode test3 = new ListNode(4);
        ListNode test4 = new ListNode(5);
        test.next = test1;
        test1.next = test2;
        test2.next = test3;
        test3.next = test4;

        ListNode tmp = new ListNode(0,test);
//        ListNode tmp = test;
        tmp = tmp.next;
        tmp.next = tmp.next.next;
        tmp.getList(tmp);
        test.getList(test);



//        ListNode node = getKthFromEnd(test,1);
//        node.getList(node);

//        int a = 1;
//        int b = a;
//        int c = b + 10;
//        b++;
//        System.out.println(a + "" + ++b + "" + c);
//        //输出二进制下该数左侧有多少个0
//        System.out.println(Integer.numberOfLeadingZeros(3));
    }

    /**
     * @Author Qi
     * @Description //TODO 获取链表的倒数第 K 个元素
     * @Date 2022/4/8 7:54
     * @Param [head, k]
     * @return com.spring.study.ListNode
    **/
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++){
            former = former.next;
        }
        former.getList(former);
        latter.getList(latter);
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    /**
     * @Author Qi
     * @Description //TODO 删除链表的倒数第 k 个元素，返回新链表
     * @Date 2022/4/8 7:56
     * @Param [node, k]
     * @return com.spring.study.ListNode
    **/
    public ListNode delKthFromEnd(ListNode node,int k){
        ListNode pre = node,end = node;
        for (int i = 0; i < k; i++){
            pre = pre.next;
        }

        while (pre != null){
            pre = pre.next;
            end = end.next;
        }
        end.next = end.next.next;
        return null;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next){
        this.val = x;
        this.next = next;
    }

    public void getList(ListNode node) {
        while(node!=null) {
            System.out.print(" " + node.val);
            node=node.next;
        }
        System.out.println();
    }

}
