How to sort in Java?

// Collections.sort
List<ObjectName> list = new ArrayList<ObjectName>();
Collections.sort(list, new Comparator<ObjectName>() {
    public int compare(ObjectName o1, ObjectName o2) {
        return o1.toString().compareTo(o2.toString());
    }
});

//If it’s an array use Array sort
// Arrays.sort
ObjectName[] arr = new ObjectName[10];
Arrays.sort(arr, new Comparator<ObjectName>() {
    public int compare(ObjectName o1, ObjectName o2) {
        return o1.toString().compareTo(o2.toString());
    }
});


//If It’s iso of set use TreeSet
// TreeSet
Set<ObjectName> sortedSet = new TreeSet<ObjectName>(new Comparator<ObjectName>() {
    public int compare(ObjectName o1, ObjectName o2) {
        return o1.toString().compareTo(o2.toString());
    }
});
sortedSet.addAll(unsortedSet);


// TreeMap - using String.CASE_INSENSITIVE_ORDER which is a Comparator that orders Strings by compareToIgnoreCase
Map<String, Integer> sortedMap = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
sortedMap.putAll(unsortedMap);


/TreeMap - In general, defined comparator
Map<ObjectName, String> sortedMap = new TreeMap<ObjectName, String>(new Comparator<ObjectName>() {
    public int compare(ObjectName o1, ObjectName o2) {
        return o1.toString().compareTo(o2.toString());
    }
});
sortedMap.putAll(unsortedMap);
