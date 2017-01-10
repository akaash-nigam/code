public static boolean binarySearch(Comparable[] A, Comparable v) {
// precondition: A is sorted (in ascending order)
    return binarySearchAux(A, 0, A.length - 1, v);
}

private static boolean binarySearchAux(Comparable[] A, int low, int high, int v) {
// precondition: A is sorted (in ascending order)
// postcondition: return true iff v is in an element of A in the range
//                A[low] to A[high]
    if (low > high) return false;
    int middle = (low + high) / 2;
    if (A[middle].equals(v)) return true;
    if (v.compareTo(A[middle]) < 0) {
        // recursively search the left part of the array
        return binarySearchAux(A, low, middle-1, v);
    }
    else {
        // recursively search the right part of the array
        return binarySearchAux(A, middle+1, high, v);
    }
}