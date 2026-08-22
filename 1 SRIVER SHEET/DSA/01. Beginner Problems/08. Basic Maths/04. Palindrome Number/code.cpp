#include<bits/stdc++.h>
using namespace std;

//Tc = O(log10(num))
//Sc = O(1)
bool palindrome(int num) {
    //Reverse the number
    int revNumber = 0;
    while(num > 0){
        int lastDigit = num % 10;
        revNumber = revNumber * 10 + lastDigit;
        num = num / 10;
    }

    //Check if the reversed number is equal to the original number
    return revNumber == num;
}

int main() {
    cout << palindrome(1221) << endl; //true
    cout << palindrome(12321) << endl; //false
    return 0;
}