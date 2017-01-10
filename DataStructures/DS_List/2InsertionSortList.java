package algorithm.sort;
 
class ListNode {
    int val;
    ListNode next;
 
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
public class SortLinkedList {
    public static ListNode insertionSortList(ListNode head) {
 
        if (head == null || head.next == null)
            return head;
 
        ListNode newHead = new ListNode(head.val);
        ListNode pointer = head.next;
 
        // loop through each element in the list
        while (pointer != null) {
            // insert this element to the new list
 
            ListNode innerPointer = newHead;
            ListNode next = pointer.next;
 
            if (pointer.val <= newHead.val) {
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {
 
                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
                        ListNode oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }
 
                    innerPointer = innerPointer.next;
                }
 
                if (innerPointer.next == null && pointer.val > innerPointer.val) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }
 
            // finally
            pointer = next;
        }
 
        return newHead;
    }
 
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
 
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
 
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
 
        n1 = insertionSortList(n1);
 
        printList(n1);
 
    }
 
    public static void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }
 
    }
}