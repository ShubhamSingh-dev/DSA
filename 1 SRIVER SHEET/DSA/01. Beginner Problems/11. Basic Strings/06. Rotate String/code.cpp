#include <bits/stdc++.h>
using namespace std;

//brute force approach
//time complexity: O(n^2)
//space complexity: O(n)
bool rotateString_bruteForce(string s, string goal) {
    int n = s.length();
    string left = "";
    if(s.length() != goal.length()) return false;
    
    for(int i = 0; i < n; i++){
        string right = s.substr(i);
        if(right + left == goal){
            return true;
        }
        left += s[i];
    }
    return false;
}

//using string concatenation
bool rotateString(string s, string goal) {
    if(s.length() != goal.length()) return false;
    string doubled_s = s + s; //concatenate the string with itself
    return doubled_s.find(goal) != string::npos; //check if the goal is a substring of the doubled string
    // string::npos means the substring was not found
}
//internally use robin karp algorithm to find the substring