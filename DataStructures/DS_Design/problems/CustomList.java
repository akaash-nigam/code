public static <T> List<T> asList(T[] a){
    return new myArrayList<T>(a);
}

private static class MyArrayList<T> extends AbstractList<T>{

private final T[] a;

MyArrayList(T[] array){
a = array;
}

public T get( int index){
    return a[index];
}

public T set(int index, T element){
    T old value = a[index];
    a[index]=element;
    return old value;
}

public int size(){
    return a.length;
}

public object[] toArray()[
    return (Object[]) a.clone();
}

