class ArrayContainer implements Comparable<ArrayContainer> {
    int[] arr;
    int index;
 
    public ArrayContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }
 
    @Override
    public int compareTo(ArrayContainer o) {
        return this.arr[this.index] - o.arr[o.index];
    }
}