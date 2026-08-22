#include<bits/stdc++.h>
using namespace std;

//Tc = O(log10(num))
//Sc = O(1)
bool isArmstrong(int num) {
    int sum = 0, count = log10(num) + 1;
    int originalNum = num;
    while(num > 0){
        int lastDigit = num % 10;
        sum = sum + pow(lastDigit, count);
        num = num / 10;
    }
    return sum == originalNum;
}

signed main() {
    cout << isArmstrong(153) << endl; //true
    return 0;
}