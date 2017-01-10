/******************************************************************************
 *  Compilation:  javac BST.java
 *  Execution:    java BST
 *  Dependencies: StdIn.java StdOut.java Queue.java
 *  Data files:   http://algs4.cs.princeton.edu/32bst/tinyST.txt  
 *
 *  A symbol table implemented with a binary search tree.
 * 
 *  % more tinyST.txt
 *  S E A R C H E X A M P L E
 *  
 *  % java BST < tinyST.txt
 *  A 8
 *  C 4
 *  E 12
 *  H 5
 *  L 11
 *  M 9
 *  P 10
 *  R 3
 *  S 0
 *  X 7
 *
 ******************************************************************************/

package edu.princeton.cs.algs4;

import java.util.NoSuchElementException;

/**
 *  The {@code BST} class represents an ordered symbol table of generic
 *  key-value pairs.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides ordered methods for finding the <em>minimum</em>,
 *  <em>maximum</em>, <em>floor</em>, <em>select</em>, <em>ceiling</em>.
 *  It also provides a <em>keys</em> method for iterating over all of the keys.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}—setting the
 *  value associated with a key to {@code null} is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses an (unbalanced) binary search tree. It requires that
 *  the key type implements the {@code Comparable} interface and calls the
 *  {@code compareTo()} and method to compare two keys. It does not call either
 *  {@code equals()} or {@code hashCode()}.
 *  The <em>put</em>, <em>contains</em>, <em>remove</em>, <em>minimum</em>,
 *  <em>maximum</em>, <em>ceiling</em>, <em>floor</em>, <em>select</em>, and
 *  <em>rank</em>  operations each take
 *  linear time in the worst case, if the tree becomes unbalanced.
 *  The <em>size</em>, and <em>is-empty</em> operations take constant time.
 *  Construction takes constant time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/32bst">Section 3.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For other implementations, see {@link ST}, {@link BinarySearchST},
 *  {@link SequentialSearchST}, {@link RedBlackBST},
 *  {@link SeparateChainingHashST}, and {@link LinearProbingHashST},
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    /**
     * Removes the smallest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the largest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 


    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 

    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) throw new NullPointerException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    } 

    /**
     * Return the kth smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the kth smallest key in the symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>N</em> &minus; 1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws NullPointerException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) throw new NullPointerException("argument to rank() is null");
        return rank(key, root);
    } 

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws NullPointerException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to keys() is null");
        if (hi == null) throw new NullPointerException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

    /**
     * Returns the number of keys in the symbol table in the given range.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return the number of keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws NullPointerException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public int size(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to size() is null");
        if (hi == null) throw new NullPointerException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }

    /**
     * Returns the height of the BST (for debugging).
     *
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     * Returns the keys in the BST in level order (for debugging).
     *
     * @return the keys in the BST in level order traversal
     */
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }




  /*************************************************************************
    *  Check integrity of BST data structure.
    ***************************************************************************/
    private boolean check() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    } 

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }
    //
    private int MinDepth(TreeNode root){
        if (root==null)
        return 0;
        else{
            if (root.left==null)
                return MinDepth(root.right)+1;
            else if (root.right==null)
                return MinDepth(root.left)+1;
            else 
                return Math.min(MinDepth(root.left),MinDepth(root.right)+1;
        }
    }
    private int MaxDepth(Treenode root){
    if (root==null) return 0;
    else {
        if (root.left==null)
            return MaxDepth(root.right)+1;
        else if MaxDepth(root.left)+1;
        else return
            (Math.max(MaxDepth(root.left,MaxDepth(root.right)+1)));
    }
    }
    public TreeNode SortedListBST(ListNode head){
    if (head==null){
        return null;
    }
    int size=0;
    ListNode fstptr = head;
    node = head;
    while(fstptr!=null){
        fstpter=fstptr.next;
        size++
    }
    return (inorderhelper(o,size))
}

    public TreeNode inOrderhelper(int start, int end){
        if (start>end { return null})
        int mid = start+ (end-start)/2l
        TreeNode left = inorderHelpr(start, mid-1);
        Treenode treenode = new TreeNode(node.val);

        TreeNode.left= lets;
        node = node.next;
        Treenode right = inorderhelper(midlef, end)
        Treenode.right - right;
        return TreeNode;
    }


    public TreeNode sortedArraytoBST(int []){
        return build (num,0.mum.light);
    }

    private TreeNode build(int[] num, int right, int left){
        if (right>left)= (right+left)/2;
        TreeNode = new TreeNode[num(mid)];
        node.left  = build (num,right,middle);
        node.right = build (num, middleleft, left);
        return node;
    }
    private isValidBST(TreeNode root){
        if (root==null) return;
        if (root.left==null && root.right=null)
        return true;
        if (root.left==null && root.right=null;
        return true;
        return check(root,Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public booelan check(Tree Node,int max, int min){
        if (node==null) return truel
        if (node.val>max|| node.val< min) return false;
    }
    public boolean isSymmetric(TreeNode root){
    if (root==null) return true;
    return isSymmetric(root.left, root.right);
}

private isSymmetric(TreeNode a, TreeNode b){
    if (a==null && b==null) return true;
    if (a==null || b == false) return false;
    if (a.val!=b.val|) return false;
    return isSymmetric(a.left, b.right) && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
}

/******************************************************************************************/
public boolean isSameTree(TreeNode p, TreeNode q){
    if p=null && q==null return true;
    if p!=null && q!== null 
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}

public void preorder(Treenode root){
    if (root!=null){
        System.out.println("%d",root.data);
        preorder(root.left);
        preorder(root.right);
    }
}

public void preorder_iter(Treenode root){
    if (root==null)return;
    Stack<Treenode> stack = new Stack<Treenode>();
    stack.push(root);
    while (!stack.empty()){
        Treenode n = stack.pop();
        System.out.println("%d",n.data);
        if (n.right!=null){
            stack.push(n.right);
        }
        if (n.left!=null){
            stack.push(n.left);
        }
    }
}


public void postOrder(TreeNode root){
    if(root!=null){
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("%d",root.data);
    }
}

public void postOrderIter(Treenode root){
    if (root==null) return;
    Stack<TreeNode> s = new Stack<TreeNode();
    TreeNode current = root;
    while (true){
        if (current!=null){
            if (current.right!=null)
                s.push(current.right);
                s.push(current);
                current=current.left;
                continue;
        }
    }

    if (s.isEmpty())
        return
    current = s.pop();
    if        if( current.right != null && ! s.isEmpty( ) && current.right == s.peek( ) ) {  
              s.pop( );  
              s.push( current );  
              current = current.right;  
          } else {
              System.out.print( current.data + " " );  
              current = null;  
          }
      }
  }
}

public void inOrder(TreeNode root) {  
  if(root !=  null) {  
   inOrder(root.left);  
   System.out.printf("%d ",root.data);  
   inOrder(root.right);  
  }  

public void inOrderIter(TreeNode root) {  
  
  if(root == null)  
   return;  
  Stack<TreeNode> s = new Stack<TreeNode>();  
  TreeNode currentNode=root; 
  while(!s.empty() || currentNode!=null){  
   if(currentNode!=null)  
   {  
    s.push(currentNode);  
    currentNode=currentNode.left;  
   }  
   else  
   {  
    TreeNode n=s.pop();  
    System.out.printf("%d ",n.data);  
    currentNode=n.right;  
   }  
  }  
 }  

 public static void levelOrderTraversal(TreeNode startNode) {  
    Queue<TreeNode> queue=new LinkedList<TreeNode>();  
    queue.add(startNode);  
    while(!queue.isEmpty())  
    {  
        TreeNode tempNode=queue.poll();  
        System.out.printf("%d ",tempNode.data);  
        if(tempNode.left!=null)  
        queue.add(tempNode.left);  
        if(tempNode.right!=null)  
        queue.add(tempNode.right);  
  }
 }


public static void printLeafNodes(TreeNode node) {  
  if(node==null)  
   return;  
  if(node.left == null && node.right == null) {  
   System.out.printf("%d ",node.data);  
  }  
  printLeafNodes(node.left);  
  printLeafNodes(node.right);  
}  


public static  int getLeafCountOfBinaryTree(TreeNode node)  
 {  
   if(node == null)
     return 0;
   if(node.left ==null && node.right==null)
     return 1;
   else  
     return getLeafCountOfBinaryTree(node.left)+ getLeafCountOfBinaryTree(node.right);       
}  

public static  int getMaximumRec(TreeNode root)  
{  
 int max=Integer.MIN_VALUE;  
 int value=0;  
 int left,right;  
 if(root != null)    
 {  
  value=root.data;  
  left=getMaximumRec(root.left);  
  right=getMaximumRec(root.right);  
  
  if(left>right)  
  {  
   max=left;  
  }  
  else  
  {  
   max=right;  
  }  
  
  if(max < value)  
  {  
   max=value;  
  }  
 }  
  
 return max;  
}

public static int getMaximumItr(TreeNode startNode) {  
 Queue<TreeNode> queue=new LinkedList<TreeNode>();  
 queue.add(startNode);  
 int max=Integer.MIN_VALUE;  
 while(!queue.isEmpty())  
 {  
  TreeNode tempNode=queue.poll();  
  if(max < tempNode.data)  
   max=tempNode.data;  
  if(tempNode.left!=null)  
   queue.add(tempNode.left);  
  if(tempNode.right!=null)  
   queue.add(tempNode.right);  
 }  
 return max;  
}


 public static void printAllPathsToLeaf(TreeNode node, int[] path, int len) {  
     if ( node == null )  
         return;  
     path[len] = node.data;  
     len++;  
  
     if(node.left == null && node.right == null) {  
         printArray(path,len);  
         return;
     }  
  
     printAllPathsToLeaf(node.left, path, len);
     printAllPathsToLeaf(node.right, path, len);
 }  

public static void printVertivalSumOfBinaryTree(TreeNode startNode,TreeMap<Integer,Integer> treeNodeMap,int level) {  
  if(startNode==null)  
  {  
   return;  
  }  

  printVertivalSumOfBinaryTree(startNode.left,treeNodeMap,level-1);  
    
  if(treeNodeMap.get(level)!=null)  
  {  
       Integer sum=treeNodeMap.get(level)+startNode.data;  
         treeNodeMap.put(level, sum);  
  }  
  else  
  {  
   treeNodeMap.put(level, startNode.data);  
  }  
  printVertivalSumOfBinaryTree(startNode.right,treeNodeMap,level+1);  
  }
}

    public static int getLevelOfNode(TreeNode root,int key,int level)  
    {  
     if(root==null)
    return 0;
    if(root.data==key)
    return level;

        int result=getLevelOfNode(root.left,key,level+1) ;
          if(result!=0)
        {   
    return result;
        }
        result= getLevelOfNode(root.right,key,level+1);
        return result;
        }


    public boolean isSubtree(Node T, Node S){
        if (S==null) return true;
        if (T==null) return true;
        if (aeridentical(T,S)return(true));
        return (isSubTree(T.left,S))|| isSubtree(T.right,s);
    }

    public boolean areidentical(Node root1, Node root2){
        if (root==null)&& root2==null
        return true;
        if (root==null|| root2 ==null)
        return false;
        return (root.data==root2.data)&&areidentical(root.left,root.right) && areidentical(root.right, root.right);
    }

    public get_ancestorofbinarytree{

    }

    public checkifBinaryTreeisSubtreeofAnother{

    }


    public check_distance_between_two_binary_trees{

    }

    public print_nodes_between_two_levels{

    }

    public deserialize_binarytree{

    }


    public remove_node_not_in_thepath{

    }

    public print_all_the_nodes_at_distance_k {

    }

    public reverse_alternate_nodes_binary_trees{

    }


    public print_left_view_node{

    }

    public check_all_nodes_at_same_level{

    }


    public in_order_traversal{

    }   

    public unique_binary_search_tress{

    }


    public validate_binary_search_tree {

    }

    public sametree {

    }


    public symmetrictree{

    }

    public binary_tree_level_order_traversal{

    }


    public binary_tree_zig_zag_level_order_traversal{

    }
    public print_nodes_from_roots_to_leaf {

    }

    public level_order_traversal{

    }
    public count_leaf_nodes{

    }

    public get_level_nodes_binary_trees{

    }


    public printancestor_binary_trees{

    }

    public checkifBinaryTreeisSubtreeofAnother{

    }

    public check_distance_between_two_binary_trees{

    }

    public find_max_path_sum_between_leavesinbinaryTrees {

    }

    public find_the_closet_leaf_node_inBT{

    }

    public find_nodes_between_two_levelnodes{

    }


    public serialize_binary_tree{

    }

    public deserialize_binary_tree{

    }

    public remove_any_nodethatdontlieinpath{

    }

    public print_all_the_nodes_at_distance_k{

    }


    public reverse_alternate_nodes_binary_trees{

    }


    public check_all_the_leave_at_SameLevel{

    }

    public lowest_common_ancestors{

    }

    public merge_bst_inspace{

    }
    public class Codec {

    // Encodes a tree to a single string.
    // We use "," to seperate information and use "N" to denote null node.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append("N").append(",");
            return;
        }
        // pre-order traversal.
        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    

    public TreeNode deserialize(String data) {
        String[] splitInfo = data.split(",");
        int[] index = new int[]{0};
        return deserializeHelper(splitInfo, index);
    }
    
    private TreeNode deserializeHelper(String[] splitInfo, int[] index) {
        // base case
        if (index[0] == splitInfo.length) {
            return null;
        }
        String cur = splitInfo[index[0]];
        if (cur.equals("N")) {
            return null;
        } else {
            TreeNode curRoot = new TreeNode(Integer.valueOf(cur));
            index[0] ++;
            curRoot.left = deserializeHelper(splitInfo, index);
            index[0] ++;
            curRoot.right = deserializeHelper(splitInfo, index);
            return curRoot;
        }
    }
}
    public printpathrec(tree, path[],pathlen){
            if nod is not null. 
            add is to print_all_the_nodes_at_distance_k path. 
        increment len. 
            if node is left print the path . 
            else. 
                print path recur(node.left, path, path)
            print (path (node.right, past, past));
            }



    public String serialize(TreeNode root) {
        if (root == null) return ",null";
        return "," + root.val + serialize(root.left) + serialize(root.right); 
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.trim().isEmpty()) return null;
        String[] nodes = data.split(",");

        TreeNode parent = null;
        int n = data.length();

        while (n >= 1) {
            int parentIndex = n / 2;
            parent = parseNum(parentIndex, nodes);
            if (parent != null) {
                parent.left = parseNum(n-1, nodes);
                parent.right = parseNum(n, nodes);
            }

            n -= 2;
        }
        return parent;
    }
    
    private TreeNode parseNum(int index, String[] nodes) {        
        if (index > nodes.length || index < 1) return null;
        String node = nodes[index-1];
        if (!node.equals("null") && !node.isEmpty()) {
            int val = Integer.parseInt(node);
            return new TreeNode(val);
        }
        return null;
    }

    String data = "";
     
    public String serialize(TreeNode root) {
        sif (root == null) {
            data += "# ";
        }
        else {
            data += root.val + " ";
            serialize(root.left);
            serialize(root.right);
        }
        return data;
    }
    
    int pos = -1;
    public TreeNode deserialize(String data) {
        pos++;
        String[] tree = data.split(" ");
        if (tree[pos].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tree[pos]));
        root.left = deserialize(data);
        root.right = deserialize(data);
        
        return root;
    }



    String data = "";
    public String serialize(TreeNode root) {
        if (root == null) {
            data += "# ";
        }
        else {
            data += root.val + " ";
            serialize(root.left);
            serialize(root.right);
        }
        return data;
    }
    
    int pos = -1;
    public TreeNode deserialize(String data) {
        pos++;
        String[] tree = data.split(" ");
        if (tree[pos].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tree[pos]));
        root.left = deserialize(data);
        root.right = deserialize(data)
        return root;
    }



class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
  
class BinaryTree 
{
    node root;
    public node lca(Node node, int n1, int n2) 
    {
        if (node == null)
            return null;
        if (node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);
        if (node.data < n1 && node.data < n2) 
            return lca(node.right, n1, n2);
        return node;
    }

    public static void main(String args[]) 
    {
        // Let us construct the BST shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
  
        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
    }
}







    /**
     * Unit tests the {@code BST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) { 
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.levelOrder())
            StdOut.println(s + " " + st.get(s));

        StdOut.println();

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}

/******************************************************************************
 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
