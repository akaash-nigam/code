public boolean isPalindrome(ListNode head) {
    if(head == null)
        return true;
 
    ListNode p = head;
    ListNode prev = new ListNode(head.val);
 
    while(p.next != null){
        ListNode temp = new ListNode(p.next.val);
        temp.next = prev;
        prev = temp;
        p = p.next;
    }
 
    ListNode p1 = head;
    ListNode p2 = prev;
 
    while(p1!=null){
        if(p1.val != p2.val)
            return false;
 
        p1 = p1.next;
        p2 = p2.next;
    }
 
    return true;
}


public boolean isPalindrome(ListNode head) {
 
    if(head == null || head.next==null)
        return true;
 
    //find list center
    ListNode fast = head;
    ListNode slow = head;
 
    while(fast.next!=null && fast.next.next!=null){
        fast = fast.next.next;
        slow = slow.next;
    }
 
    ListNode secondHead = slow.next;
    slow.next = null;
 
    //reverse second part of the list
    ListNode p1 = secondHead;
    ListNode p2 = p1.next;
 
    while(p1!=null && p2!=null){
        ListNode temp = p2.next;
        p2.next = p1;
        p1 = p2;
        p2 = temp;
    }
 
    secondHead.next = null;
 
    //compare two sublists now
    ListNode p = (p2==null?p1:p2);
    ListNode q = head;
    while(p!=null){
        if(p.val != q.val)
            return false;
 
        p = p.next;
        q = q.next;
 
    }
 
    return true;
}



public class Solution {
    ListNode left;
 
    public boolean isPalindrome(ListNode head) {
        left = head;
 
        boolean result = helper(head);
        return result;
    }
 
    public boolean helper(ListNode right){
 
        //stop recursion
        if (right == null)
            return true;
 
        //if sub-list is not palindrome,  return false
        boolean x = helper(right.next);
        if (!x)
            return false;
 
        //current left and right
        boolean y = (left.val == right.val);
 
        //move left to next
        left = left.next;
 
        return y;
    }
}