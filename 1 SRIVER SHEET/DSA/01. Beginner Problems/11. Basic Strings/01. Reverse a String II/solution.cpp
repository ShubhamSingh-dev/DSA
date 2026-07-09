#include <bits/stdc++.h>
using namespace std;

int main() {
    //AS i am using two pointer approach, and travering half of the array
    //TC - 0(n/2) and SC - 0(1)
    string s = "shubham";
    int left = 0, right = s.length() - 1;
    while(left < right) {
        swap(s[left], s[right]);
        left++, right--;
    }
    cout << s << endl;
    return 0;
}