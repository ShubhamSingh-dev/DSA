#include <bits/stdc++.h>
using namespace std;

int sumOfFirstNnumbers(int n){
    if(n == 0) return 0;
    return n + sumOfFirstNnumbers(n - 1);
}