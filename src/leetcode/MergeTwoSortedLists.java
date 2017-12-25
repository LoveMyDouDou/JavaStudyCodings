package leetcode;

public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode result_head=null;

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                result.next=l1;
                l1=l1.next;
            }
            else {
                result.next=l2;
                l2=l2.next;
            }
            result=result.next;
            if(result_head==null){
                result_head=result;
            }
        }

        if(l1==null){
            result.next=l2;
        }
        else {
            result.next=l1;
        }
        return result_head;
    }









    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}
