#include <bits/stdc++.h>
using namespace std;

//Time complexity: O(N * M * logN) , Space complexity: O(M)
string longestCommonPrefix(vector<string> &strs) {
    // Edge case: empty vector
        if (strs.empty()) return "";
        
        // Sort the vector to get the lexicographically smallest and largest strings
        sort(strs.begin(), strs.end());
        // First string (smallest in sorted order)
        string first = strs[0]; 
        // Last string (largest in sorted order)
        string last = strs[strs.size() - 1]; 
        
        // Compare characters of the first and last strings
        int minLength = min(first.size(), last.size());
        string ans = "";
        for (int i = 0; i < minLength; i++) {
            // If characters don't match, return the current prefix
            if (first[i] != last[i]) {
                return ans;
            }
            // Append the matching character to the result
            ans += first[i];
        }
        
        // Return the longest common prefix found
        return ans;
}
signed main() {
    vector<string> input = {"flower", "flow", "flight"};
    string result = longestCommonPrefix(input);
    cout << "Longest Common Prefix: " << result << endl; // Output: "fl"
    return 0;
}