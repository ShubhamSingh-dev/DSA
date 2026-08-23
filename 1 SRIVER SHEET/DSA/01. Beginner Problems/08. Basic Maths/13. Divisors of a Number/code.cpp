#include <bits/stdc++.h>
using namespace std;

//Tc = O(sqrt(n))
//Sc = O(1)

void divisors(int n) {
    list<int> ls;
    for(int i = 1; i <= sqrt(n); i++) {
        if(n % i == 0) {
            ls.push_back(i);
        }
    }
}