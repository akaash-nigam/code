//isUglyNo
public boolean isUgly(int num) {
    if(num==0) return false;
    if(num==1) return true;
 
    if(num%2==0){
        num=num/2;
        return isUgly(num);
    }
 
    if(num%3==0){
        num=num/3;
        return isUgly(num);
    }
 
    if(num%5==0){
        num=num/5;
        return isUgly(num);
    }
 
    return false;
}

//Nth Ugly No
public int nthUglyNumber(int n) {
    if(n<=0)
        return 0;
 
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1);
 
    int i=0;
    int j=0;
    int k=0;
 
    while(list.size()<n){
        int m2 = list.get(i)*2;
        int m3 = list.get(j)*3;
        int m5 = list.get(k)*5;
 
        int min = Math.min(m2, Math.min(m3, m5));
        list.add(min);
 
        if(min==m2)
            i++;
 
        if(min==m3)
            j++;
 
        if(min==m5)
            k++;
    }
 
    return list.get(list.size()-1);
}

//superUglyNo
public int nthSuperUglyNumber(int n, int[] primes) {
    int[] times = new int[primes.length];
    int[] result = new int[n];
    result[0] = 1; // first is 1
 
    for (int i = 1; i < n; i++) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < primes.length; j++) {
            min = Math.min(min, primes[j] * result[times[j]]);
        }
 
        result[i] = min;
 
        for (int j = 0; j < times.length; j++) {
            if (result[times[j]] * primes[j] == min) {
                times[j]++;
            }
        }
    }
 
    return result[n - 1];
}


//find k pairs 
public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<int[]> result = new ArrayList<int[]>();
 
    k = Math.min(k, nums1.length*nums2.length);
 
    if(k==0)
        return result;
 
    int[] idx = new int[nums1.length];
 
    while(k>0){
        int min = Integer.MAX_VALUE;
        int t=0;
        for(int i=0; i<nums1.length; i++){
            if(idx[i]<nums2.length && nums1[i]+nums2[idx[i]]<min){
                t=i;
                min = nums1[i]+nums2[idx[i]];
            }
        }
 
        int[] arr = {nums1[t], nums2[idx[t]]};    
        result.add(arr);
 
        idx[t]++;
 
        k--;
    }
 
    return result;
}
