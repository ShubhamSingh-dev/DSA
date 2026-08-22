#include<bits/stdc++.h>
using namespace std;

//Tc = O(log10(num))
//Sc = O(1)
int largestDigit(int num) {
    int largest = 0;
    while(num > 0){
        int lastDigit = num % 10;
        largest = max(largest, lastDigit);
        num = num / 10;
    }
    return largest;
}

int main() {
    cout << largestDigit(3379) << endl;
    return 0;
}