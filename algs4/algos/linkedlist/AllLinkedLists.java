public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

/***************************************************************/


public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}
/***************************************************************/
public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}

/***************************************************************/
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
/***************************************************************/
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

/***************************************************************/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        // Check whether we have work to do
        if (head == null || head.next == null) return result;
        ListNode slow = head, fast = head, reverseHead = null;
        while (fast != null && fast.next != null) {
            // Move fast pointer two nodes at a time
            fast = fast.next.next;
            // Move slow pointer one node at a time, reversing the first half of the list along the way
            ListNode temp = slow.next;
            slow.next = reverseHead;
            reverseHead = slow;
            slow = temp;
        }
        ListNode mid = slow;
        // Move slow pointer one node forward if the length of the list is odd
        if (fast != null) slow = slow.next;
        // Navigate to the ends of the list, comparing values for equality
        // and restoring the reversed half of the list
        while (slow != null) {
            if (slow.val != reverseHead.val) result = false;
            slow = slow.next;
            ListNode temp = reverseHead.next;
            reverseHead.next = mid;
            mid = reverseHead;
            reverseHead = temp;
        }
        return result;
    }
}


public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode rev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            head.next = rev;
            rev = head;
            head = slow;
        }
        
        if (fast != null) {
            while (slow.next != null && rev != null && slow.next.val == rev.val){
                slow = slow.next;
                rev = rev.next;
            }
            return rev == null;
        }
        else {
            while (slow != null && rev != null && slow.val == rev.val){
                slow = slow.next;
                rev = rev.next;
            }
            return rev == null;
        }

public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode fast, slow;
        fast = slow = head;
        
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //fast will be null if number of nodes is even
        if(fast!=null) slow=slow.next;
        
        slow = reverseList(slow);
        fast = head;
        
        while(fast!=slow && slow!=null){
            if(fast.val!=slow.val)
                return false;
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }

/***************************************************************/
public ListNode reverseList(ListNode head) {
        if(head.next==null) return head;
        ListNode prev, curr, next;
        prev = next = null;
        curr = head;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
}

public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

/***************************************************************/

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        while(head!=null && head.val==val){
            head=head.next;
        }
        ListNode temp = head;
        while(temp!=null){
            ListNode temp2=temp.next;
            while(temp2!=null && temp2.val==val){
                temp2=temp2.next;
            }
            temp.next = temp2;
            temp = temp.next;
        }
        return head;
    }
}


 public ListNode removeElements(ListNode head, int val) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode p = fake;
        while (p != null &&p.next !=null){
            if (p.next.val == val){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return fake.next;
    }

public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode previous = head;
        
        if (head == null) {
            return null;
        }
        
        while (current != null) {
            if (current.val == val) {
                if (current == head) {
                    head = current.next;
                    current = head;
                    previous = current;
                } else {
                    previous.next = current.next;
                    current = previous.next;
                }
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}



 public class Solution {
 public ListNode removeElements(ListNode head, int val) {
   if(head == null)
       return null;
    
   ListNode tmp = new ListNode(0);
   tmp.next = head;
   
   ListNode previous;
   ListNode current;
   
   previous=tmp;
   current=head;
   
   while(current != null)
   {
       if(current.val == val)
       {
           current=current.next;
           previous.next=current;
       }
   
       else if(current.val != val)
       {
           previous=current;
           current=current.next;
       }
   }
   return tmp.next;
}



///Intersection of two flatten_linkedlist

Approach #3 (Two Pointers) [Accepted]

Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
If at any point pA meets pB, then pA/pB is the intersection node.
To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, because pB traverses exactly 2 nodes less than pA does. By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.
Complexity Analysis

Time complexity : O(m+n)O(m+n).
Space complexity : O(1)O(1).


public class Solution {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    
    private ListNode sortList(ListNode begin, ListNode end) {
        if (begin == end) {
            if (begin != null) begin.next = null;
            return begin;
        }
        
        // find middle node.
        ListNode slow = begin;
        ListNode fast = begin.next;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        ListNode left = sortList(begin, slow);
        ListNode right = sortList(fast, end);
        
        // Merge lists
        begin = dummy;
        while (left != null && right != null) {
            if (right.val < left.val) {
                begin.next = right;
                right = right.next;
            } else {
                begin.next = left;
                left = left.next;
            }
            
            begin = begin.next;
            begin.next = null;
        }
        
        begin.next = left != null ? left : right;
        
        return dummy.next;
    }
}





public class Solution {
    public ListNode sortList(ListNode head) {
        return split(head);
    }
    
    public ListNode split(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null || head.next == null) return head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        return merge(split(head),split(fast));
    }
    
    public ListNode merge(ListNode l,ListNode r) {
        ListNode dum = new ListNode(0), n = dum;
        
        while (l != null && r != null) {
            if (l.val < r.val) {
                n.next = l;
                n = n.next;
                l = l.next;
            } else {
                n.next = r;
                n = n.next;
                r = r.next;
            }
        }
        
        while (l != null) {
            n.next = l;
            n = n.next;
            l = l.next;
        }
        while (r != null) {
            n.next = r;
            n = n.next;
            r = r.next;
        }
        
        return dum.next;
    }
}



public class Solution {
    public ListNode sortList(ListNode head) {
 
        int len = length(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int size = 1; size < len; size *= 2) {
            // Head of left sub-list
            ListNode head1 = dummy.next;
            ListNode tail = dummy;
            while (head1 != null) {
                tail.next = head1;
                // Head of right sub-list
                ListNode head2 = moveSize(head1, size);
                if (head2 != null) {
                    ListNode nextHead = moveSize(head2, size);
                    tail = merge(tail, head1, head2);
                    head1 = nextHead;
                } else {
                    break;
                }
            }
        }
        return dummy.next;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }

    // Get the node that is size to the right of the head
    private ListNode moveSize(ListNode head, int size) {
        ListNode newHead = head;
        for (int i = 0; i < size; i++) {
            if (newHead == null)
                return null;
            if (i == size - 1) {
                // Set tail to null
                ListNode tmp = newHead.next;
                newHead.next = null;
                newHead = tmp;
            } else {
                newHead = newHead.next;
            }
        }
        return newHead;
    }

    // merge two sorted linkedlist and return the new tail of merged list
    private ListNode merge(ListNode tail, ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }
        // link to the non-empty list
        if (head1 == null)
            tail.next = head2;
        if (head2 == null)
            tail.next = head1;
        // move to the end
        while (tail.next != null)
            tail = tail.next;
        return tail;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = new ListNode(0);
        pre.next = slow.next;
        fast = slow.next;
        slow.next = null;
        while(fast != null && fast.next != null){
            ListNode tmp = fast.next;
            fast.next = fast.next.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        while(pre.next != null){
            ListNode tmp = pre.next;
            pre.next = pre.next.next;
            tmp.next = head.next;
            head.next = tmp;
            head = head.next.next;
        }
    }
}



 public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head, fast = head;
        LinkedList<ListNode> stk = new LinkedList<>();
      //Detect the cutting node by slow-fast-runner
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
      //Cut the list, push the second part into stack
        ListNode toInsert = slow.next;
        slow.next = null;
        while(toInsert != null){
            stk.push(toInsert);
            toInsert = toInsert.next;
        }
        slow = head;
        fast = slow.next;
      //Insert nodes of second part into first part at every interval between two nodes.
        while(!stk.isEmpty()){
            slow.next = stk.pop();
            slow.next.next = fast;
            slow = fast;
            fast = slow.next;
        }
    }



public class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        while(head!=null){
            dq.add(head);
            head = head.next;
        }
        ListNode sentinal = new ListNode(0);
        ListNode tail = sentinal;
        boolean fromFirst = true;
        while(dq.size()!=0){
            if(fromFirst){
                tail.next = dq.pollFirst();
                fromFirst = false;
            }else{
                tail.next = dq.pollLast();
                fromFirst = true;
            }
            tail = tail.next;
            tail.next = null;
        }
    }
}

public void reorderList(ListNode head) {
    ListNode headtemp;
    ListNode backtemp;
    if (head != null && head.next != null) {
        ListNode mid = Findmiddle(head);
        ListNode back = reverse(mid.next);
        mid.next = null;
        while (back != null){
            headtemp = head.next;
            backtemp = back.next;
            head.next = back;
            back.next = headtemp;
            back = backtemp;
            head = headtemp;
        }
    }
}





public class Solution {
public ListNode reverse(ListNode head){
if(head==null||head.next==null) return head;
ListNode temp1 = null;
ListNode temp2 = head.next;
while (head != null && head.next != null){
head.next = temp1;
temp1 = head;
head = temp2;
temp2 = temp2.next;
}
head.next = temp1;
return head;
}


private ListNode Findmiddle (ListNode head){
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}




public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length  = 0;
    ListNode first = head;
    while (first != null) {
        length++;
        first = first.next;
    }
    length -= n;
    first = dummy;
    while (length > 0) {
        length--;
        first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
}

/***************************************************************/
class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}


public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mL(lists, 0, lists.length - 1);
    }
    
    private ListNode mL(ListNode[] lists, int l, int r) {
        if (r < l) return null;
        if (r == l) return lists[r];
        
        int mid = (l + r) / 2;
        ListNode a = mL(lists, l, mid), b = mL(lists, mid + 1, r);
        ListNode dmHead = new ListNode(0), cur = dmHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;
        
        return dmHead.next;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return helper(lists,0,lists.length - 1);
    }
    public ListNode helper(ListNode[] list, int left, int right){
        if(left==right) {
            return list[left];
        }
        else{
            int mid = left + (right - left)/2;
            ListNode one = helper(list,left,mid);
            ListNode two = helper(list,mid+1,right);
            return merge(one,two);
        }
    }
    public ListNode merge(ListNode a, ListNode b){
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(a!=null||b!=null){
            if(a!=null&&b!=null){
                if(a.val<b.val) {
                    dummy.next = new ListNode(a.val);
                    a = a.next;
                }
                else {
                    dummy.next = new ListNode(b.val);
                    b = b.next;
                }
            }else if(a!=null){
                dummy.next = new ListNode(a.val);
                a = a.next;
            }else{
                dummy.next = new ListNode(b.val);
                b = b.next;
            }
            dummy = dummy.next;
        }
        return head.next;
    }
}

/***************************************************************/

public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode runner = head;
        
        while (runner != null && runner.next != null) {
            int temp = runner.val;
            runner.val = runner.next.val;
            runner.next.val = temp;
            runner = runner.next.next;
        }
        return head;
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode newHead = head.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
            if (cur != null && cur.next != null) tmp.next = cur.next;
        }
        return newHead;
    }
}


public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;
        
        second.next = head;
        head.next = swapPairs(third);
        
        return second;
    }
}


/* recursion */
public ListNode swapPairs2(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode tmp = head.next;
    head.next = swapPairs(tmp.next);
    tmp.next = head;
    return tmp;
}

public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode cur = head, pre = new ListNode(0);
    pre.next = head;
    head = pre;
    /* it maybe not easy to understand, you'd better draw a figure */
    while (cur != null && cur.next != null) {
        pre.next = cur.next;
        cur.next = pre.next.next;
        pre.next.next = cur;
        pre = cur;
        cur = cur.next;
    }
    return head.next;
}


public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode runner = head;
        
        while (runner != null && runner.next != null) {
            int temp = runner.val;
            runner.val = runner.next.val;
            runner.next.val = temp;
            runner = runner.next.next;
        }
        
        return head;
    }

/***************************************************************/

public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) { // find the k+1 node
        curr = curr.next;
        count++;
    }
    if (count == k) { // if k+1 node is found
        curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
        // head - head-pointer to direct part, 
        // curr - head-pointer to reversed part;
        while (count-- > 0) { // reverse current k-group: 
            ListNode tmp = head.next; // tmp - next head in direct part
            head.next = curr; // preappending "direct" head to the reversed list 
            curr = head; // move head of reversed part to a new node
            head = tmp; // move "direct" head to the next node in direct part
        }
        head = curr;
    }
    return head;
}


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 1) return head;
        
        int count = countNode(head);
        if(count < k) return head;

        // reverse the first k nodes
        ListNode newHead = null;
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }

        head.next = reverseKGroup(cur, k);
        return newHead;
        
    }
    public int countNode(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}

/***************************************************************/

public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;


}


public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode start = head;
        while (start != null) {
            int val = start.val;
            while (start != null && start.val == val) {
                start = start.next;
            }
            if (prev.next.next == start) prev = prev.next;
            prev.next = start;
        }
        return dummy.next;
}

public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = new ListNode(0);
        ListNode dup = new ListNode(0);
        pre.next = head;
        dup.next = head.next;
        ListNode res = pre;
        while(dup.next != null){
            if(dup.next.val == pre.next.val){
                while(dup.next != null && dup.next.val == pre.next.val) 
                    dup = dup.next;
                pre.next = dup.next;
                if(dup.next != null)
                    dup = dup.next;
            }else{
                dup = dup.next;
                pre = pre.next;
            }
        }
        
        return res.next;
    }
}
/***************************************************************/

public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode tail = helper;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = tail.next;
            }
            while(head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
        }
        tail.next = null;
        return helper.next;
}

/***************************************************************/
public ListNode deleteDuplicates(ListNode head){
        if(head==null) return null;
        
        ListNode pre=head;
        ListNode node=head.next;
    
        while(node!=null)
        {
            if(pre.val==node.val)
            {
                pre.next=node.next;
            }else
            {
            pre=pre.next;
            }
            node=node.next;
        }
        return head;
}


public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next==null) return head;
        ListNode r = head;
        ListNode root = head;
        while(head!=null){
            if(head.next!=null && head.val == head.next.val){
                root = head;
                while(root.next!=null && root.val==root.next.val) root = root.next;
                head.next = root.next;
            }
            head = head.next;
        }
        return r;
}

/***************************************************************/

public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode beforeXStart = null;
        ListNode beforeXEnd = null;
        ListNode afterXStart = null;
        ListNode afterXEnd = null;
        
        ListNode curr = head;
        while(curr != null) {
            if (curr.val < x) {
                if (beforeXStart == null) {
                    beforeXStart = curr;
                    beforeXEnd = curr;
                } else {
                    beforeXEnd.next = curr;             
                    beforeXEnd = beforeXEnd.next;                   
                }
            } else {
                if (afterXStart == null) {
                    afterXStart = curr;
                    afterXEnd = curr;
                } else {
                    afterXEnd.next = curr;              
                    afterXEnd = afterXEnd.next;                 
                }
            }                       
            curr = curr.next;
        }
        if (beforeXEnd == null) {
            return head;
        }
        beforeXEnd.next = afterXStart;
        if (afterXEnd != null) {
            afterXEnd.next = null;
        }
        return beforeXStart;
    }
}

public ListNode partition(ListNode head, int x) {
    ListNode smallhead = new ListNode(0); //2 dummy heads
    ListNode bighead = new ListNode(0);
    ListNode small = smallhead; //2 iterators
    ListNode big = bighead;
    while(head!=null){
        ListNode temp = new ListNode(head.val);
        if(head.val<x){
            small.next = temp;
            small = small.next;
        }
        else{
            big.next = temp;
            big = big.next;
        }
        head = head.next;
    }
    small.next = bighead.next;//connect 2 lists
    return smallhead.next;
}

public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode head1, p1 = new ListNode(0), head2, p2 = new ListNode(0);
    head1 = p1;
    head2 = p2;
    while (head != null) {
        if (head.val < x) {
            p1.next = head;
            p1 = p1.next;
        } else {
            p2.next = head;
            p2 = p2.next;
        }
        head = head.next;
    }
    p2.next = null;
    p1.next = head2.next;
    return head1.next;
}

/***************************************************************/



public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        while(head.next!=null && head.next!=head){
            ListNode tmp=head.next;
            head.next=head.next.next;
            head=tmp;
        }
        return head.next!=null;
}

public boolean hasCycle(ListNode head) {
        if( head == null) return false;
        ListNode fast, slow=fast=head;
        while( fast != null && fast.next != null) {
            fast = fast.next.next;  //2x fast
            slow = slow.next;       //1x fast
            if( fast == slow) return true;
        }
        return false;
}

public boolean hasCycle(ListNode head) {
        if(head == null)return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head))return true;
            set.add(head);
            head = head.next;
        }
        return false;
}

/***************************************************************/

public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
}



public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        boolean first = true;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode tmp1 = head;
                ListNode tmp2 = slow;
                while (tmp1 != tmp2){
                    tmp1 = tmp1.next;
                    tmp2 = tmp2.next;
                }
                return tmp1;
            }
        }
        return null;
    }
 
}


public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        if (head.next.next == head) return head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}


/***************************************************************/
public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode after;

        while (curr != null) {
            after = curr.next;
            if (curr.val >= prev.val)
                prev = curr;
            else {
                ListNode tprev = null;
                ListNode temp = head;
                while (temp != curr) {
                    if (curr.val <= temp.val) {
                        if (tprev == null)
                            head = curr;
                        else
                            tprev.next = curr;
                        curr.next = temp;
                        prev.next = after;
                        break;
                    } else {
                        tprev = temp;
                        temp = temp.next;
                    }
                }
            }
            curr = after;
        }
        return head;
    }


public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        while(head.next != null){
            if(head.next.val >= head.val){
                head = head.next;
            }else{
                while(pre.next != null){
                    if(pre.next.val > head.next.val){
                        ListNode temp = pre.next;
                        pre.next = head.next;
                        head.next = head.next.next;
                        pre.next.next = temp;
                        break;
                    }else{
                        pre = pre.next;
                    }
                }
                pre = res;
            }
        }
        
        return res.next;
}
/***************************************************************/



/*
Approach #3 (Two Pointers) [Accepted]

Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
If at any point pA meets pB, then pA/pB is the intersection node.
To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, because pB traverses exactly 2 nodes less than pA does. By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.
Complexity Analysis

Time complexity : 
O
m
n
O(m+n).
Space complexity : 
O
1
O(1).
Analysis written by @stellari.
*/



public print_reverse (ListNode head){
    if (head==null) return;
    print_reverse(head.next);
    system.out.println()
}

public sortedinsert(Node head,Node new_head){
    if (head==null)|| head.data>= new_node.next
        head=new_node;
    else{
        current=head;
        while(current.next!=null& curren)
    }
}


public ListNode findMiddle(ListNode head){

}

public ListNode removeNthFromEnd(ListNode head){

}

public quickSort(ListNode head){

}

public ListNode FindLoop(ListNode head){
    while(slwptr!=null & fstptr!=null){
        slwptr=slwptr.next;
        if (fastptr.next!=null) && fastpter.next!=null)
            fastptr= fastptr.next;
            else return false;
            if (slowptr==fastpr) return true;
    }

}
public remove_loop (ListNode head){
    fast = head;
    while(fast.next!=slow.next)
    {
        fast=fast.next;
        slow=slow.next;
    }
    start=fast.next;
    fast=start
    while(fast.next!=start)
        fast=null;
    fast.next=null;
}

public flatten_linkedlist(ListNode head){
    if (root==null)|| root.rightl
        return (root);
    return merge(root,flatten(root.right));
}

public static Node reverse(Node head){
    Node n = head, next;
    while(n.next() != null){
        next = n.next;
        n.next = n.prev;
        n.prev = next;
        n = next;
    }
    // n is the new head.
    return n;
}

