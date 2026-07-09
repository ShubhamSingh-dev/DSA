#include <bits/stdc++.h>
using namespace std;

int main() {
    //AS i am using two pointer approach
    //TC - 0(n/2) and SC - 0(1)
    string s = "madam";
    int left =0, right = s.length() - 1;
    while(left < right) {
        if(s[left] != s[right]) {
            cout << "Not Palindrome" << endl;
            return 0;
        }
        left++, right--;
    }
    cout << "Palindrome" << endl;
    return 0;
}