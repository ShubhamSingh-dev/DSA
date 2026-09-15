#include <bits/stdc++.h>

using namespace std;

string largestOddNumberInString(string s) {

    int n = s.length();
    int j = -1;

    // Find the rightmost odd digit
    for(int i = n - 1; i >= 0; i--) {
        if((s[i] - '0') % 2 == 1) {
            j = i;
            break;
        }
    }

    // No odd digit found
    if(j == -1) return "";

    // Remove leading zeroes
    int i = 0;
    while(i <= j && s[i] == '0') i++;

    return s.substr(i, j - i + 1);
}

int main() {

    string s = "002031438";

    cout << largestOddNumberInString(s) << endl;

    return 0;
}