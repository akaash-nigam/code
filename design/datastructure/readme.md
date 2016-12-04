Design questions. 
Is it a data structure design?
1. Data structure and methods. 
    1. Design a Key Value Store?
    2. Design the "what other people bought feature." This was focused on database design/creating an api to lie on top of it, and he asked questions to see if I understood how dbs actually work(like what does group by do). I was given an example table with the schema of like  itemID, purchaseDate, customerID  He asked big O complexity of sql query as well.
    3. There is a huge HashMap (Key-Value store). This is present in storage, dont worry about the Storage.  1. Build its index. Distributed system for indexing. Different cases: Key is a String/ Double/ complex structure, etc. How will you replicate this index structure - whole index is replicated/ parts of index are replicated.  2. How will you synchronize access (read/ write) if there are multiple replicas of the index partition. What if the actual Storage partition also has replicas.
