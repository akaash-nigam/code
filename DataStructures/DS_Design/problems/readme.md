
* AbstractCollection class
* AbstractList class. 
* AbstractSet class
* AbstractSequentialList.
* AbstractQueue
* AbstractMap

Immutable Objects. 
- An object is considered immutable if it’s state cannot be changed and constructed. 
- Immutable objects are useful in concurrent applications. they cannot change state, they cannot be corrupted by thread interface. 

A Strategy of Defining Immutable Objects. 

* don’t provide setters methods. 
* make all the field private and final. 
* don’t allow subclass to override. 
* if instance fields include 
    * don’t provide methods to modify mutable objects. 
    * 

    l