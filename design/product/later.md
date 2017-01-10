

— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— 
Testing based questions. 
1. Test amazon websites: two categories with 100 people.. Buying a product, Customer Information, Order Tracking. 
2. Complete Automation design framework.
3. Echo devices lights up when questions are asked, but does not answers the question. 
4. Client send a string to server and server responds back with same string. list down the test cases. 
——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— 
coding 
1. find minimum from the stream. 
2. longest increasing subsequence. 
3. longest decreasing subsequence. 
——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— 

1. Number of 1's in binary representation of integer?
2. List all anagrams in a file. Assumptions: case-insensitive, a-z characters only, one word per line. For example, if the file contains dog, cat, ddd, goo, act, god -- output dog, god, act, cat
3. If you have a file containing millions of integers, how would you sort the data in the file using extremely limited resources, such a s 1GB of memory?
4. 

a primitive class having two string attributes and one attribute list of the class itself and then we have to get the each level's string variables's printed....




What is different between UDP and TCP/IP? Why do you use one over another?
find words through a grid maze of characters.



Write a function to display the power set of a set of integers; set={1,2} powerSet = {{},{1},{2},{1,2}}
transform a [1,0] matrix grid into matrix grid of manhattan distance between closest 1's
Binary tree algorithm question.
Flood filling in 2-D matrix


Write an algorithm to determine whether a given number is of the form (2^n)+1, where n is an integer.
Implement a function to validate whether a given binary tree is a BST (i.e. write an isBST() function).
Traverse nodes in Binary Tree   
Determine whether the binary representation of a number if a palindrome or not, code it on a white board.
Given an integer set of numbers, print all the subsets. For some reason the interviewer asked to print the supersets, but what he means is subsets.
"Solve a maze", you have a 2D matrix with 1's as blocked and 0's as path. Find a path from one corner to another, backtracking should be allowed.
Given a binary tree with the usual left and right pointers on each node, and additionally a parent pointer, make an algorithm to discover the closest ancestor to 2 nodes on the tree.
Write a program to count the number of words in a file.

Given 2 strings find the common words along with the time and space complexity. How would you optimize the algorithm

how to get the most significant bit from a byte?

The difference between and interface and an abstract class
Find the max ;length palindrome in an input string.
How would you count the number of words in a string consisting of uneven number of spaces between words( not dictionary words)? With and without library functions.

- Find k-th element from the end of the singlylinked list in single pass?

Given 4 points, write a method to determine if the 4th point is in the triangle made by the first 3 points



1. Write a function that divides one number by another, without using the division operator, and make it better than O(n).?
2. Merge two sorted LinkedList.
3. Find LCA of two nodes of Binary Trees. 
4. Collection of String, output the one that occurs more often. 
5. How can we store the name of street in a map service? Because street names have characters in common.
6. Design a system to provide services to users / clients to obtain uuid .
7. Check if all the leaves are at the same level in a binary tree
8. Implement an LRU Cache, and a BST tree question
9. Given a set of number ranges, i.e. [1,5], [3,6], [7,9], write a program to merge overlapping number ranges. In the above example, the result should be [1,6], [7,9].
10. Print the "outside" nodes of a binary tree counter clockwise .

Amazon Questions from CareerCup

1. Given an array of numbers. Print all the pairs (2) of numbers in the array if the sum of those numbers is also present in the array. Write in C
2. Given an array of numbers. Print all the pairs (2) of numbers in the array if the sum of those numbers is also present in the array. Write in C
3. Vertical Zig Zag Order. 
4. 


Design Questions.
Amazon Lockers - Customers can use these lockers to have their products delivered. These lockers are physically available to customers at the same or several nearby zip codes.
Given that an external service gives a list of credit cards that have become fraud, design a fraud management system for a shopping website for bookings with fraud credit cards



Q1) Given an array 'A' of size 'n' and a number 'm' such that 'm <= n'. For all subsets of 'A' of size 'm', return the difference between the number of non-increasing and non-decreasing sub-sequences. 

Given N ropes of lengths L1, L2, L3, L4, …, LN. I had to join every rope to get a final rope of length L1 + L2 + … + LN.  However, I can join only two ropes at a time and the cost of joining the two ropes is L1 + L2. I was supposed to join ropes in such a way that the cost is minimum.

lic class MinimunRopeJoiningCost {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] temp = br.readLine().trim().split(" ");
        for ( String s: temp){
            pq.add(Integer.parseInt(s));
        }
        Integer result = new Integer(0);
        while(pq.size()>;1){
            Integer a = pq.remove();
            Integer b = pq.remove();
            result = result + a+b;
            pq.add(a+b);
        }
        System.out.println(result);
    }
}



Given an array of 0s and 1s, and k, Find the longest continuous streak of 1s after flipping k 0s to 1s.   E.x array is {1,1,0,0,1,1,1,0,1,1}  k = 1 (which means we can flip ‘k’ one 0 to 1)   Answer: 6 (if we flip 0 at index 7, we get the longest continuous streak of 1s having length 6)
- neer.1304 February 14, 2016 in United States | Report Duplicate | Flag 



Today is school picture day and everybody,  including the teacher, has lined up in a single line for the class picture.  Design an O(n log n) Java code that computes the minimum number of swaps necessary to be in order














