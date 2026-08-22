#include<bits/stdc++.h>
using namespace std;

//Tc = O(sqrt(num))
//Sc = O(1)

int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b, a % b);
}

signed main() {
    cout << gcd(4, 6) << endl; //2
    return 0;
}  