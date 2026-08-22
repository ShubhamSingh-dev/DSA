#include<bits/stdc++.h>
using namespace std;

//Tc = O(n * sqrt(num))
//Sc = O(1)
bool isPrime(int num) {
    if(num <= 1) return false;
    for(int i = 2; i * i <= num; i++) {
        if(num % i == 0) return false;
    }
    return true;
}

int countPrimeNumbers(int n) {
    int count = 0;
    for(int i = 2; i <= n; i++) {
        if(isPrime(i)) count++;
    }
    return count;
}

signed main() {
    cout << countPrimeNumbers(10) << endl; //4
    return 0;
}