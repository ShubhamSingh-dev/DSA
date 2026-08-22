#include<bits/stdc++.h>
using namespace std;

//Tc = O(log10(num))
//Sc = O(1)
int reverseNumber(int num) {
    int revNumber = 0;
    while(num > 0){
        int lastDigit = num % 10;
        revNumber = revNumber * 10 + lastDigit;
        num = num / 10;
    }
    return revNumber;
}

int main() {
    cout << reverseNumber(3379) << endl;
    return 0;
}