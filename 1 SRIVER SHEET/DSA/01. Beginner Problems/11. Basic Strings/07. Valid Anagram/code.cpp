#include <bits/stdc++.h>
#include <vector>
using namespace std;

//brute force
//time complexity: O(nlogn)
//space complexity: O(1)
bool isAnagram_bruteForce(string s, string t) {
    if(s.length() != t.length()) return false;
    sort(s.begin(), s.end());
    sort(t.begin(), t.end());
    return s == t;
}

bool isAnagram(string s, string t) {
    if(s.length() != t.length()) return false;
    vector<int> count(26, 0);

    // Count occurence of each character in first string
    for(char c : s) count[c - 'a']++;

    // Decrement the count for each character in the second string
    for (char c : t) count[c - 'a']--;

    // Check for count of every character
    for (int i : count) {
        // If the count is not zero
        if (i != 0) return false; // Return false
    }
    // Otherwise strings are anagram
    return true;
}