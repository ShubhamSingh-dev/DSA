#include<bits/stdc++.h>
using namespace std;

//Tc = O(sqrt(num))
//Sc = O(1)
int isPerfectNumber(int num) {
    int sum = 0;
    for(int i = 1; i * i <= num; i++) {
        if(num % i == 0) {
            sum += i;
            if(i != num / i) {
                sum += num / i;
            }
        }
    }
    return (sum == num);
}

signed main() {
    cout << isPerfectNumber(3379) << endl;
    return 0;
}