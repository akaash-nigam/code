public int[] countBits(int num) {
    int[] result = new int[num+1];
 
    for(int i=0; i<=num; i++){
        result[i] = countEach(i);
    }
 
    return result;
}
 
public int countEach(int num){
    int result = 0;
 
    while(num!=0){
        if(num%2==1){
            result++;
        }
        num = num/2;
    }
 
    return result;
}

public int[] countBits(int num) {
    int[] result = new int[num+1];
 
    int p = 1; //p tracks the index for number x
    int pow = 1;
    for(int i=1; i<=num; i++){
        if(i==pow){
            result[i] = 1;
            pow <<= 1;
            p = 1;
        }else{
            result[i] = result[p]+1;
            p++;
        }
 
    }
 
    return result;
}