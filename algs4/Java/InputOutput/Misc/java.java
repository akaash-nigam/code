1. ArrayList. 
2. Set s = new Set<SortedSet>();
3. Map map = new Map<Hashmap>();
4. Map map = new Map<SortedMap>()

List<String> list = new ArrayList<String>(c);
List<String> list = new ArrayList<>(c);
List<String> list = new ArrayList<>(c);

The Collection interface contains methods that perform basic operations, such as 
—— —— —— —— —— —— —— —— —— —— 
- int size(), 
- boolean isEmpty(), 
- boolean contains(Object element), 
- boolean add(E element), 
- boolean remove(Object element), and 
- Iterator<E> iterator().
—— —— —— —— —— —— —— —— —— —— 
It also contains methods that operate on entire collections, such as 
- boolean containsAll(Collection<?> c), 
- boolean addAll(Collection<? extends E> c),
- boolean removeAll(Collection<?> c), 
- boolean retainAll(Collection<?> c),
-  void clear().

Additional methods for array operations (such as Object[] toArray() and <T> T[] toArray(T[] a) exist as well.

public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove(); //optional
}


Collection Interface Bulk Operations
Bulk operations perform an operation on an entire Collection. You could implement these shorthand operations using the basic operations, though in most cases such implementations would be less efficient. The following are the bulk operations:
* containsAll — returns true if the target Collection contains all of the elements in the specified Collection.
* addAll — adds all of the elements in the specified Collection to the target Collection.
* removeAll — removes from the target Collection all of its elements that are also contained in the specified Collection.
* retainAll — removes from the target Collection all its elements that are not also contained in the specified Collection. That is, it retains only those elements in the target Collection that are also contained in the specified Collection.
* clear — removes all elements from the Collection.

Array Operations. 
1. Object[] a = c.toArray();
2. String[] a = c.toArray(new String[0]);
—— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— 
Sets Interface  
1. Collection<Type> noDups = new HashSet<Type>(c);
Set Bulk Operations

Collection<Type> noDups = new HashSet<Type>(c);
* s1.containsAll(s2) — returns true if s2 is a subset of s1. (s2 is a subset of s1 if set s1 contains all of the elements in s2.)
* s1.addAll(s2) — transforms s1 into the union of s1 and s2. (The union of two sets is the set containing all of the elements contained in either set.)
* s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2. (The intersection of two sets is the set containing only the elements common to both sets.)
* s1.removeAll(s2) — transforms s1 into the (asymmetric) set difference of s1 and s2. (For example, the set difference of s1 minus s2 is the set containing all of the elements found in s1 but not in s2.)

—— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— 
List Interface

list1.addAll(list2);

List<Type> list3 = new ArrayList<Type>(list1);
list3.addAll(list2);

List<String> list = people.stream()
.map(Person::getName)
.collect(Collectors.toList());


public class Shuffle {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (String a : args)
            list.add(a);
        Collections.shuffle(list, new Random());
        System.out.println(list);
    }
}
—— 
for (ListIterator<Type> it = list.listIterator(list.size()); it.hasPrevious(); ) {
    Type t = it.previous();
    ...
}

public int indexOf(E e) {
    for (ListIterator<E> it = listIterator(); it.hasNext(); )
        if (e == null ? it.next() == null : e.equals(it.next()))
            return it.previousIndex();
    // Element not found
    return -1;
}

public static <E> void replace(List<E> list, E val, E newVal) {
    for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
        if (val == null ? it.next() == null : val.equals(it.next()))
            it.set(newVal);
}

public static <E> 
    void replace(List<E> list, E val, List<? extends E> newVals) {
    for (ListIterator<E> it = list.listIterator(); it.hasNext(); ){
        if (val == null ? it.next() == null : val.equals(it.next())) {
            it.remove();
            for (E e : newVals)
                it.add(e);
        }
    }
}


List Algorithms
* sort — sorts a List using a merge sort algorithm, which provides a fast, stable sort. (A stable sort is one that does not reorder equal elements.)
* shuffle — randomly permutes the elements in a List.
* reverse — reverses the order of the elements in a List.
* rotate — rotates all the elements in a List by a specified distance.
* swap — swaps the elements at specified positions in a List.
* replaceAll — replaces all occurrences of one specified value with another.
* fill — overwrites every element in a List with the specified value.
* copy — copies the source List into the destination List.
* binarySearch — searches for an element in an ordered List using the binary search algorithm.
* indexOfSubList — returns the index of the first sublist of one List that is equal to another.
* lastIndexOfSubList — returns the index of the last sublist of one List that is equal to another.
—— —— —— —— —— —— —— —— 
queue interface
public interface Queue<E> extends Collection<E> {
    E element();
    boolean offer(E e);
    E peek();
    E poll();
    E remove();
}
    
—— —— —— —— —— —— —— ——————————
Deque Interface
Deque Methods
Type of Operation   First Element (Beginning of the Deque instance) Last Element (End of the Deque instance)
Insert  addFirst(e) offerFirst(e)   addLast(e)  offerLast(e)
Remove  removeFirst()   pollFirst() removeLast()    pollLast()
Examine getFirst()  peekFirst() getLast()   peekLast()
—— ———————————— ——————————
Map Interface

pop[
—— ——————————
Sorted Set Interface.




—— ——————————
Sorted Map Interface. 



Talking about Interfaces


Queue Interace
1. add(e)   Offer(e)
2. Remove() Poll()
3. Element() Peek()




How to insert in the DeQueue. 
—— —— —— —— 
addFirst(E)
offerFirst(E)     
addLast(E)
 offerLast(E)
—— —— —— —— 
RemoveFirst(E)  
removeLast(E)
pollFirst(E)         
 pollLast(E)
—— —— —— —— 
getFirst()           getLast()
peekFirst()        
getLast()
peekLast()
—— —— —— —— 
Talking about Implementation. 
Different types of Implementation. .
————————————————
Set s  = new <HashSet>();
Set s = new <TreeSet>();
Set s = new <LinkedHashSet>();

HashSet is much faster than TreeSet (constant-time versus log-time for most operations) but offers no ordering guarantees
 If you need to use the operations in the SortedSet interface, or if value-ordered iteration is required, use TreeSet; otherwise, use HashSet. It's a fair bet that you'll end up using HashSet most of the time.

LinkedHashSet is in some sense intermediate between HashSet and TreeSet. Implemented as a hash table with a linked list running through it, it provides insertion-orderediteration (least recently inserted to most recently) and runs nearly as fast as HashSet. The LinkedHashSet implementation spares its clients from the unspecified, generally chaotic ordering provided by HashSet without incurring the increased cost associated with TreeSet.

One thing worth keeping in mind about HashSet is that iteration is linear in the sum of the number of entries and the number of buckets (the capacity). Thus, choosing an initial capacity that's too high can waste both space and time. On the other hand, choosing an initial capacity that's too low wastes time by copying the data structure each time it's forced to increase its capacity. If you don't specify an initial capacity, the default is 16. In the past, there was some advantage to choosing a prime number as the initial capacity. This is no longer true. Internally, the capacity is always rounded up to a power of two. The initial capacity is specified by using the int constructor. The following line of code allocates aHashSet whose initial capacity is 64.

There are two special-purpose Set implementations — EnumSet and CopyOnWriteArraySet.
EnumSet is a high-performance Set implementation for enum types. All of the members of an enum set must be of the same enum type. Internally, it is represented by a bit-vector, typically a single long. Enum sets support iteration over ranges of enum types. For example, given the enum declaration for the days of the week, you can iterate over the weekdays. The EnumSet class provides a static factory that makes it easy.
    for (Day d : EnumSet.range(Day.MONDAY, Day.FRIDAY))
        System.out.println(d);
Enum sets also provide a rich, typesafe replacement for traditional bit flags.
    EnumSet.of(Style.BOLD, Style.ITALIC)


CopyOnWriteArraySet is a Set implementation backed up by a copy-on-write array. All mutative operations, such as add, set, and remove, are implemented by making a new copy of the array; no locking is ever required. Even iteration may safely proceed concurrently with element insertion and deletion. Unlike most Set implementations, the add,remove, and contains methods require time proportional to the size of the set. This implementation is only appropriate for sets that are rarely modified but frequently iterated. It is well suited to maintaining event-handler lists that must prevent duplicates.


List ll = new <ArrayList>();
List ll = new <LinkedList>();
ist implementations are grouped into general-purpose and special-purpose implementations.
General-Purpose List Implementations
There are two general-purpose List implementations — ArrayList and LinkedList. Most of the time, you'll probably use ArrayList, which offers constant-time positional access and is just plain fast. It does not have to allocate a node object for each element in the List, and it can take advantage of System.arraycopy when it has to move multiple elements at the same time. Think of ArrayList as Vector without the synchronization overhead.
If you frequently add elements to the beginning of the List or iterate over the List to delete elements from its interior, you should consider using LinkedList. These operations require constant-time in a LinkedList and linear-time in an ArrayList. But you pay a big price in performance. Positional access requires linear-time in a LinkedList and constant-time in an ArrayList. Furthermore, the constant factor for LinkedList is much worse. If you think you want to use a LinkedList, measure the performance of your application with both LinkedList and ArrayList before making your choice; ArrayList is usually faster.
ArrayList has one tuning parameter — the initial capacity, which refers to the number of elements the ArrayList can hold before it has to grow. LinkedList has no tuning parameters and seven optional operations, one of which is clone. The other six are addFirst, getFirst, removeFirst, addLast, getLast, and removeLast. LinkedListalso implements the Queue interface.

Special-Purpose List Implementations
CopyOnWriteArrayList is a List implementation backed up by a copy-on-write array. This implementation is similar in nature to CopyOnWriteArraySet. No synchronization is necessary, even during iteration, and iterators are guaranteed never to throw ConcurrentModificationException. This implementation is well suited to maintaining event-handler lists, in which change is infrequent, and traversal is frequent and potentially time-consuming.
If you need synchronization, a Vector will be slightly faster than an ArrayList synchronized with Collections.synchronizedList. But Vector has loads of legacy operations, so be careful to always manipulate the Vector with the List interface or else you won't be able to replace the implementation at a later time.
If your List is fixed in size — that is, you'll never use remove, add, or any of the bulk operations other than containsAll — you have a third option that's definitely worth considering. See Arrays.asList in the Convenience Implementations section for more information.

———————————————— 
Dequeue m = new <ArrayDequeu>();
Dequeue m = new <LinkedList>();
————————————————
Map m1 = new <HashMap>();
map m2 = new <TreeMap>();
Map m3 = new <LinkedHashMap();
————————————————
* For the Set interface, HashSet is the most commonly used implementation.
* For the List interface, ArrayList is the most commonly used implementation.
* For the Map interface, HashMap is the most commonly used implementation.
* For the Queue interface, LinkedList is the most commonly used implementation.
* For the Deque interface, ArrayDeque is the most commonly used implementation.

Methods of List Iterator
* add
* hashNext()
* hasPrevious()
* next()
* previous()
* previousIndex()
* remove()
* set()


Interface Map
* clear()
* computer
* computeIfAbsent
* ComputeifPresent
* ContainsKey
* containsValue
* entrySet
* equals
* ForEach
* get
* goorDefault
* keyset()
* merge
* put 
* petal
* putifAbsent
* remove
* replace
* replaceAll
* size()
* values()


InterfaceList
* add
* addAll
* clear()
* contains
* equals
* get
* hashcode()
* index
* isEmpty)
* iterator()
* lastIndexOf
* remove
* remove(Object)
* spliterator()
* subList()
* toArray()
* toArray(T{[] a)

Interface Queue
* add (E e)
* element()
* offer (E e)
* peek()
* poll()
* remove()

Interface Set
* add
* addAll
* clear()
* contains()
* containsAll
* equals
* HashCode()
* isEmpty()
* iterator()
* remove(Object o)
* removeAll
* retainAll
* size()
* spliterator()
* toArray()

Interface SortedMap
* sortedMap
* Set
* sortedMap
* sortedMap
* collections


================================================================================================
———
Primitive

interfaces
1. appendeable
2. autoacloseable
3. cloneable
4. comparable
5. Iterable
6. Readable
7. Runnable


Boolean. 
- boolean           BooleanValue()
- static int           compare()
- int                    compareTo()
- boolean           equals()
- Static Boolean getBoolean()
- int                     hashCode()
- boolean            parseBooelan()
- String               toString()
- Boolean           ValueOf()

Character
- int charCount (int codePoint)
- char charValue()
- int codePointAt
- int codePointAt
- int codePointBefore
- int compare
- int compreTo
- int digit
- into digit
- int equal
- char fordigit()
————————
Boolean
- booleanValue()
- compare
- compareTo
- equals
- getBoolean
- hashCode
- parseBooelan
- toString()
- toString()
- valueOf()
———————— 
Byte
- byteValue()
- compare   
- compareTo
- decode
- doubleValue
- equals
- floatValue()
- hashcode()
- intValue()
- longValue()
- parseByte()
- parseByte()
- ShortValue()
- toString()
- valueOf
————————
character
- charCount
- charValue
- codePointAt
- codePointAt
- codePointBefore
- codePointBefore
- codePointCount
- compare
- compareTo
- digit
- equals
- forDigit
- getDirectionality
- getName
- getType
- getName
- hashCode()
- isDefined()
- isDigit()
- isLetter()
- isLowerCase()
- isSpaceChar()
- isUpperCase()
- toCodePoint()
- toString()
- toTitleCase()
- valueOf(char c)

————————
double
- byteValue()
- compare
- compareTo
- doubletoLongBits
- doubleValue()
- equal
- hashCode()
- intValue)
- isInfinite()
- longValue()
- parseDouble()
- shortValue()
- toString()
- toString()
- valueOf

————————
Enum
- clone
- compareTo
- equals
- finalize
- getDeclaringClass
- hashcode
- name
- ordinal
- toString
- valueOf
————————
Float
- byteValue
- compare
- compareTo
- doubleValue
- equals
- 
- floatValue()
- hashCode()
- 
- isInfinite()\

- intValue()
- longValue()
- shortValue()
- toString
- floatToIntBits
- floatToRawBits
- toString(float f)
- valueOf
- Value
————————
Integer
- bitCount()
- byteValue()
- compare
- compreTo
- decodes
- doubleValue()
- equals
- floatValue()
- getInteger
- getInteger
- getInteger
- hashCode
- highestOnebit
- intValue
- longValue
- lowestonebit
- numberofleadingzeroes
- numberoftrailingzeroes
- parseInt
- reverse
- reverseBytes
- rotateLeft
- rotateRight
- shortValue
- signum
- toBinaryString
- toHexString
- toOctalString
- toString
- toString
- valueOf(int i)
- valueOf(String s)
- valueOf(String s) 

——— 
long
- bitCount()
- byteValue
- compare
- compareTo
- decode
- doubleValue
- equals
- floatValue
- getLong
- getting
- hashcode()
- highestOneBit
- intValue
- longValue()
- lowestOneBit()
- NumberOfLeadingZerioes()
- decode()
- intValue()
- reverse()
- toOctalString
- toString
- Value
—— 
Number
- byteValue()
- doubleValue()
- floatValue()
- intValue()
- longValue()
- shortValue()
—— 
StringBuilder
- append (boolean b) 
- append (char c )
- append (char[] str)
- append ()
- append (char sequence)
- append (char sequence, int start, int end)
- append (double b)
- append (float f)
- append (long long)
- append (Object obj)
- append (StringBuffer sb)
- appendCodePoint (int Codepoint)

- delete(int start, int end)
- deleteCharAt


- subString
- toString

- capacity ()
- codePointAt()
- codePointBefore()
- ensureCapacity
- getChars
- indexOf
- insert
- lastIndexOf
- replace
- reverse
- setCharAt
- setLength
- subSequence
- trimToSize()
——— 
Object
- clone()
- equals()
- finalize()
- getClass()
- hashCode()
- notify()
- notifyAll)
- wait()
- wait(long time out)

—— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— 
Arrays. 

int[]            anArray             =   new int[10];
byte[]         anArrayOfBytes =  new byte[10];
short[]        anArrayOfShorts = new short[10];
long[]         anArrayOfLongs = new long[10];
float[]         anArrayOfFloats = new float[50];
double[]     anArrayOfDoubles = new double[100];
boolean[]   anArrayOfBooleans = new boolean[100];
char[]         anArrayOfChars = new chars[100];
String[]      anArrayOfStrings = new String[893];

public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
—— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— —— 
Collections. 
￼

* The <E> syntax tells you that the interface is generic. When you declare a Collection instance you can and should specify the type of object contained in the collection. Specifying the type allows the compiler to verify (at compile-time) that the type of object you put into the collection is correct, thus reducing errors at runtime. For information on generic types, see the Generics (Updated) lesson.
* Set: a collection that cannot contain duplicate elements. This interface models the mathematical set abstraction and is used to represent sets, such as the cards comprising a poker hand, the courses making up a student's schedule, or the processes running on a machine. See also The Set Interface section.
    * Sorted Set
* an ordered collection (sometimes called a sequence). Lists can contain duplicate elements. The user of a List generally has precise control over where in the list each element is inserted and can access elements by their integer index (position). If you've used Vector, you're familiar with the general flavor of List. Also see The List Interface section.
*  a collection used to hold multiple elements prior to processing. Besides basic Collection operations, a Queue provides additional insertion, extraction, and inspection operations.
* Deque — a collection used to hold multiple elements prior to processing. Besides basic Collection operations, a Deque provides additional insertion, extraction, and inspection operations. Deques can be used both as FIFO (first-in, first-out) and LIFO (last-in, first-out). In a deque all new elements can be inserted, retrieved and removed at both ends. Also see The Deque Interface section.
* Map — an object that maps keys to values. A Map cannot contain duplicate keys; each key can map to at most one value. If you've used Hashtable, you're already familiar with the basics of Map. Also see The Map Interface section.
    * Sorted Map



================================================================================================
Miscellaneous 
1. 
Java concepts
————————————————————————————————————————————————————————
Object
- An object is a software bundle of related state and behaviour
- Software objects are often used to model the real-world objects that you find in everyday life.
- This lesson explains how state and behaviour are represented within an object, introduces the concept of data encapsulation, and explains the benefits of designing your software in this manner.
Class:
- A class is a blueprint or prototype from which objects are created. This section defines a class that models the state and behaviour of a real-world object. 
- It intentionally focuses on the basics, showing how even a simple class can cleanly model state and behavior.

Inheritance
- Inheritance provides a powerful and natural mechanism for organizing and structuring your software. This section explains how classes inherit state and behaviour from their superclasses, and explains how to derive one class from another using the simple syntax provided by the Java programming language.
Interface
- An interface is a contract between a class and the outside world. When a class implements an interface, it promises to provide the behaviour published by that interface. This section defines a simple interface and explains the necessary changes for any class that 
Package
- A package is a namespace for organizing classes and interfaces in a logical manner. Placing your code into packages makes large software projects easier to manage. This section explains why this is useful, and introduces you to the Application Programming Interface (API) provided by the Java platform.
———————————————————————————————————————————————— 
List of Operators. 
Operator Precedence
Operators   Precedence
postfix   expr++ expr--
unary      ++expr --expr +expr -expr ~ !
multiplicative  * / %
additive    + -
shift            << >> >>>
relational  < > <= >= instanceof
equality    == !=
bitwise AND &
bitwise exclusive OR    ^
bitwise inclusive OR    |
logical AND &&
logical OR  ||
ternary ? :
assignment  = += -= *= /= %= &= ^= |= <<= >>= >>>=
———————————————————————————————————————————————— 
In general-purpose programming, certain operators tend to appear more frequently than others; for example, the assignment operator "=" is far more common than the unsigned right shift operator ">>>". With that in mind, the following discussion focuses first on the operators that you're most likely to use on a regular basis, and ends focusing on those that are less common. Each discussion is accompanied by sample code that you can compile and run. Studying its output will help reinforce what you've just learned.
1. Assignment. 
2. Equality, 
3. Bitwise. 
———————————————————————————————————————————————— 
1. Expression
2. Statement 
3. Blocks

Control Flow. 
1. If then If Else
2. Switch
3. while and do while
4. for 
5. branching statement

Everything about Classes and Objects
- Different Ways of Declaring Classes
- Declaring Member Variables
- Defining Methods
- Providing Constructor for Your Classes
- Passing Information to a Method or a Constructor. 

Objects
1. Creating Objects. 
2. Using Objects. 

More on Classes
1. Returning value: https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
2. using this keyword
3. controlling access to member class. 
4. Understanding Class Members.

Initializing Fields.
Nested Classes
Annotations. 
Interface and Inheritance.
Number and Strings. 
Generics. 
Packages. 
==================================================================================================
Miscellaneous-2
Boards About Input/Output
——————————
FilterInputStream
FilterOutputStream
FilterReader
FilterWriter
——————————
BufferedInputStream (FilteredInputStream);
BufferedOutputStream (FilteredOutputStream);
BufferedReader (FilteredReader)
BufferedWriter (FilteredWriter) 
——————————
FileInputStream
FileOutputStream
FileReader
FileWriter
——————————
Specialized Classes.    
InputStreamReader
InputStream
ByteArrayInputStream
ByteArrayOutputStream
CharArrayReader
CharArrayWriter
DataInputStream
DataOutputStream
ObjectStream
ObjectSteam 
OutputStream
OutputStream
——————————
PipedReader
PipedWriter
——————————
PushBackInputStream
PushBackWriter.
——————————
StringReader
StringWriter
——————————

All the classes
All the methods


- Byte Streams
- Character Streams
- Buffered Streams
- Data Stream. 
- Object Stream 
- Input/output from the command line.
- Path of the file. 
    - relative file
    - absolute file
- File operations
    - checking for a file
    - checking for a directory. 
- Reading, Writing and creating files.
- Creating and Reading directories
    - The java.nio.file package provides extensive support for file and file system I/O. This is a very comprehensive API, but the key entry points are as follows:
        * The Path class has methods for manipulating a path.
        * The Files class has methods for file operations, such as moving, copy, deleting, and also methods for retrieving and setting file attributes.
        * The FileSystem class has a variety of methods for obtaining information about the file system.
Interfaces
* Closable
* DataInput
* DataOutput
* Externalizable
* FilenameFilter
* Flushable
* ObjecInput
* ObjectOutput
* ObjectStream
* Serializable
——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— 
Byte Input/Stream