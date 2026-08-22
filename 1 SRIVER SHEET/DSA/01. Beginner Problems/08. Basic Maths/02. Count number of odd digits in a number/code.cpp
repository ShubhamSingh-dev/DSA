#include<bits/stdc++.h>
using namespace std;

int countOddDigits(int num) {
    if(num == 0) return 0;
    int countOdd = 0;
    while(num > 0){
        int lastDigit = num % 10;
        if(lastDigit % 2 != 0){
            countOdd++;
        }
        num = num / 10;
    }

    return countOdd;
}

int main() {
    cout << countOddDigits(3379) << endl;
}