package com.allan;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class MergeTwoSortedList
{
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while ( l1 != null && l2 != null ){
            if ( l1.val < l2.val ){
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null)? l1 : l2;
        System.out.println("cur >>>" );
        printListNode(cur);
        System.out.println("cur <<<" );
        return dummy.next;
    }

    static void printListNode( ListNode in){
        while( in != null ){
            System.out.println( in.val);
            in  = in.next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode( 1);
        a.next = new ListNode ( 3);
        a.next.next = new ListNode ( 5);

        ListNode b = new ListNode ( 2);
        b.next = new ListNode ( 4);
        b.next.next = new ListNode ( 5);
        //     b.next.next.next.next = new ListNode ( 20);
        //     b.next.next.next = new ListNode ( 10);
        printListNode(a);
        System.out.println();
        printListNode(b);
        System.out.println();
        ListNode result = mergeTwoLists(a, b);
        printListNode(result);
    }
}