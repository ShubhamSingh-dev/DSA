#include<bits/stdc++.h>
using namespace std;

//Tc = O(n)
//Sc = O(1)
int factorial(int num) {
    int fact = 1;
    for(int i = 1; i <= num; i++) {
        fact = fact * i;
    }
    return fact;
}

int main() {
    cout << factorial(9) << endl;
    return 0;
}