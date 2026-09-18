#include <bits/stdc++.h>
using namespace std;

bool palindrome(int l, int r, string s){
    if(l >= r) return true;
    
    if(s[l] != s[r]) return false;

    return palindrome(l + 1, r - 1, s);
}

int main(){
    string s = "hannah";
    int l = 0;
    int r = s.length() - 1;
    cout << palindrome(l,  r,  s);
}

