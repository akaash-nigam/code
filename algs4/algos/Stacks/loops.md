for loops
* Initliazation condition; termination condition; increment or decrement condition

Array Index of Size N. 
0, 1, 2, 3, 4, 5, 6, 7, 8, N.(0, N-1) 

What is better way of visualizing this. 
Think of for loop index in terms of the array indices. 
You are reducing one level of abstraction this ways. 
Because that is where we are using these indices. 

Insertion Sort. 
for (int i=2;i<arr.lenght;i++)
{
    j = i-1;
    while (i>0) && a[j]>a[i])
    {
        swap a[i] with aj[
        int temp;
        temp = a[i];
        a[j]= a[i]
        i = i -1;
    }
}


for (int i=2; i< arr.length;  i++)
{
    j=i-1;

    while (i >0) && a[j]>a[i])
    {
        //swap  a[j] with a[i]
        int temp;
        temp = a[j];
        a[i] = key;
        i = i-1;
    }

}

The outer loop here is running from 2 to N. 
The inner loop here is running from 1 to i-1. 
    In the inner loop we are just comparing the successive elements and placing the array in order. 


analysis: 
extra space = O(1) 
extra spaxe= O(n)

Stable, Inplace, Online. 





we are first taking the first two elements and then comparing them. 
we are then taking the next three elements and then comparing them. 
we are then taking the next four elements and then comparing them 
we are then taking the next five elements and then comparing them. 
we are then taking the next six elements and then comparing them. 
we are then taking the next seven element and then comparing them. 
we are then taking the next eight elements and then comparing them.

for an array of 5( so what are we doing here
* for the very first loop ( i=2, j=1)
    * arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]
    *  i= 1: so the while loop will be executed once. the logic inside will keep swapping the elements. 
* for the very second loop (i=3, j=2)
    * while (i>0. it will compare successive elements and swap them.
    * i=2: one loop 
    * i=1: second loop
    * i=0: third loop. 
* for the very third loop (i=4, j=3) 
    * while (
        * i=4
        * i=3
        * i=2
        * i=1; 
* for the very fourth loop( i=5, j=4) 
    * while
        * i=5
        * i=4
        * i=3
        * i=2
        * i=1. 
* for the very fifth loop (i=5, j=5)
    * while. 
        * i=5
        * def
* for the very sixth loop (i, j)
        * i=6
        * i=5
        * i=4
        * i]3
        * i=2
        * i=1;

pick the element and place it in the sorted array. 



Selection Sort. 
keep comparing successive elements and place it in the sorted Array. 


Bubble Sort.
Bubble up the




Merge Sort. 















































