#include <bits/stdc++.h>
using namespace std;

string main() {
    //TC - 0(n) and SC - 0(1)
    string s = "002031438";
    int n = s.length(), j = -1;
    int i;
    for(i = n - 1; i >= 0; i--) {
        if((s[i] - '0') % 2 == 1){
            j = i;
            break;
        }
    }
    if(j == -1) return "";

    i = 0;
    while(i <= j && s[i] == '0') i++;
    return s.substr(i, j - i + 1);
}