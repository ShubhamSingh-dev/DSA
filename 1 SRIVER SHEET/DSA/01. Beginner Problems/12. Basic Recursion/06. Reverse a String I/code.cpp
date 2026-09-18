#include <bits/stdc++.h>
#include <vector>
using namespace std;

void reverse(int left, int right, vector<char>& s){
    if (left >= right) return;
    
    char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

    reverse(left + 1, right - 1, s);
}

vector<char> reverseString(vector<char>& s) {
    int left = 0;
    int right = s.size() - 1;
    reverse(left, right, s);
    return s;
}