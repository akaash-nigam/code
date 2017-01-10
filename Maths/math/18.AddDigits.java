public int addDigits(int num) {
    int sum=0;
 
    String s = String.valueOf(num);
    for(int i=0; i<s.length(); i++){
        sum = sum + (s.charAt(i)-'0');
    }
 
    if(sum < 10){
        return sum;
    }else{
        return addDigits(sum);
    }
}

public int addDigits(int num) {
    return num - 9*((num-1)/9);
}