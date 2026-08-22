#include<bits/stdc++.h>
using namespace std;

//Tc = O(sqrt(num))
//Sc = O(1)
bool isPrime(int num) {
    if(num <= 1) return false;
    for(int i = 2; i * i <= num; i++) {
        if(num % i == 0) return false;
    }
    return true;
}

signed main() {
    cout << isPrime(37) << endl; //true
    return 0;
}