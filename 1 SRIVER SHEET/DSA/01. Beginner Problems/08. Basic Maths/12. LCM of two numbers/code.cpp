#include <bits/stdc++.h>
using namespace std;

//Tc = O(log(min(a, b)))
//Sc = O(1)

int gcd(int a, int b) {
    while(a != 0 && b != 0) {
        if(a > b) a = a % b;
        else b = b % a;
    }
    return a + b;
}

int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}

int lcm_without_gcd(int a, int b) {
    int maxNum = max(a, b);
    int i = 1;
    do {
        int multiple = maxNum * i;
        if(multiple % a == 0 && multiple % b == 0) return multiple;
        i++;
    } while(1);
    return -1; //this will never be reached
}