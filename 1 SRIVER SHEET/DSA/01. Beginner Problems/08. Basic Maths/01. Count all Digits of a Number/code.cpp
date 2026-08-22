#include<bits/stdc++.h>
using namespace std;

int countDigits(int num) {
    if (num == 0) return 1;
    int count = 0;
    while (num > 0) {
        count++;
        num = num / 10;
    }
    return count;
}

int countDigits_log(int num) {
    if (num == 0) return 1;
    return floor(log10(num)) + 1;
    // Here we follow the formula  [  log10(num) + 1 ]   to count the digits of a number
    /*
        log10(10^2) -> 2 x log10(10) -> 2 x 1(if base and num are same than 1) -> 2
    */
}

int main() {
    cout << countDigits(5628) << endl;
    cout << countDigits_log(5628) << endl;
}