
double myPow(double x, int n) {
    if(n<0) return 1/x * myPow(1/x, -(n+1));
    if(n==0) return 1;
    if(n==2) return x*x;
    if(n%2==0) return myPow( myPow(x, n/2), 2);
    else return x*myPow( myPow(x, n/2), 2);
}
————————————————————————————————————
double myPow(double x, int n) { 
    if(n==0) return 1;
    double t = myPow(x,n/2);
    if(n%2) return n<0 ? 1/x*t*t : x*t*t;
    else return t*t;
}
——————————————————————————————
double myPow(double x, int n) { 
    if(n==0) return 1;
    if(n<0){
        n = -n;
        x = 1/x;
    }
    return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
}

————————————————————————
Public Class Solution{
double myPow(double x, int n) { 
    if(n==0) return 1;
    if(n<0) {
        n = -n;
        x = 1/x;
    }
    double ans = 1;
    while(n>0){
        if(n&1) ans *= x;
        x *= x;
        n >>= 1;
    }
    return ans;
}
}
——————————————————————————————

Public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n == Integer.MIN_VALUE) return 0;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        double ret = 1.0;
        while (n > 0) {
            if ((n & 1) != 0) 
                ret *= x;
            x = x * x;
            n = n >> 1;
        }
        return ret;
    }
}

public double myPow(double x, int n) {
    if(n == 0) return 1;
    if(Math.abs(x-0.0)<0.0000001) return 0.0;
    if(Math.abs(x-1.0)<0.0000001) return 1.0;    
    if(n < 0) x = 1.0/x;
    return Power(x, Math.abs(n));
}
————————————————————————
double Power(double x, int n){
    if(n == 0) return 1;
    if(n == 1) return x;
    return ((n&0x1) == 1) 
————————————————————————
public class Solution {
public:
    double myPow(double x, long int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            // For negative exponent, just take inverse.
            return 1.0/myPow(x, -n);
        }
        if (n % 2) {
            return x * myPow(x, n - 1);
        } else {
            double y = myPow(x, n/2);
            return y * y;
        }
    }
};





public boolean isPowerOfTwo(int n) {
    if(n<=0) 
        return false;
 
    while(n>2){
        int t = n>>1;
        int c = t<<1;
 
        if(n-c != 0)
            return false;
 
        n = n>>1;
    }
 
    return true;
}



public boolean isPowerOfTwo(int n) {
    return n>0 && (n&n-1)==0;
}


public boolean isPowerOfTwo(int n) {
    return n>0 && n==Math.pow(2, Math.round(Math.log(n)/Math.log(2)));
}




public boolean isPowerOfFour(int num) {
    while(num>0){
        if(num==1){
            return true;
        }
 
        if(num%4!=0){
            return false;
        }else{
            num=num/4;
        }
    }
 
    return false;
}

public boolean isPowerOfFour(int num) {
    int count0=0;
    int count1=0;
 
    while(num>0){
        if((num&1)==1){
            count1++;
        }else{
            count0++;
        }
 
        num>>=1;
    }
 
    return count1==1 && (count0%2==0);
}

public boolean isPowerOfFour(int num) {
   if(num==0) return false;
 
   int pow = (int) (Math.log(num) / Math.log(4));
   if(num==Math.pow(4, pow)){
       return true;
   }else{
       return false;
   }
}




public boolean isPowerOfThree(int n) {
    if(n==1) return true;
 
    boolean result = false;
 
    while(n>0){
        int m = n%3;
        if(m==0){
            n=n/3;
            if(n==1)
                return true;
        }else{
            return false;
        }
    }
} 
 public boolean isPowerOfThree(int n) {
    if(n==0) 
        return false;
 
    if(n==1) 
        return true;
 
    if(n>1) 
        return n%3==0 && isPowerOfThree(n/3);
    else
        return false;
}


public boolean isPowerOfThree(int n) {
    if(n==0) return false;
 
    return n == Math.pow(3, Math.round(Math.log(n)/Math.log(3)));
}




public boolean isPowerOfFour(int num) {
    while(num>0){
        if(num==1){
            return true;
        }
 
        if(num%4!=0){
            return false;
        }else{
            num=num/4;
        }
    }
 
    return false;
}

public boolean isPowerOfFour(int num) {
    int count0=0;
    int count1=0;
 
    while(num>0){
        if((num&1)==1){
            count1++;
        }else{
            count0++;
        }
 
        num>>=1;
    }
 
    return count1==1 && (count0%2==0);
}


public boolean isPowerOfFour(int num) {
   if(num==0) return false;
 
   int pow = (int) (Math.log(num) / Math.log(4));
   if(num==Math.pow(4, pow)){
       return true;
   }else{
       return false;
   }
}
