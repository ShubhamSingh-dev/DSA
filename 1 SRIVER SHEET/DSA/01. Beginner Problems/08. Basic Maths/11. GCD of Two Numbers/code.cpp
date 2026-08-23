#include<bits/stdc++.h>
using namespace std;

//Tc = O(sqrt(num))
//Sc = O(1)


//Euclidean Algorithm (Basic one - this takes lot of time complexity)
// int gcd(int a, int b) {
//     while(a != 0 && b != 0) {
//         if(a > b) a = a - b;
//         else b = b - a;
//     }
//     if(b == 0) return a;
//     return b;
// }


//Euclidean Algorithm (Optimized one - this takes less time complexity)
int gcd(int a, int b) {
    while(a != 0 && b != 0) {
        if(a > b) a = a % b;
        else b = b % a;
    }
    return a + b;
}

signed main() {
    cout << gcd(4, 6) << endl; //2
    return 0;
}  