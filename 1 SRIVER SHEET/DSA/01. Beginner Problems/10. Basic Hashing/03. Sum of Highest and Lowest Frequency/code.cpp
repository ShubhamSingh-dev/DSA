#include <bits/stdc++.h>
using namespace std;

//Brute Force Approach
//Time Complexity: O(n^2)
//Space Complexity: O(1)
int sumOfHighestAndLowestFrequency_bruteforce(int arr[], int n){
    int vis[10001] = {0};
    int maxFreq = 0, minFreq = n;

    for(int i = 0; i <= n - 1; i++){
        if(vis[arr[i]] == 0){
            vis[arr[i]] = 1;
            int cnt = 0;

            for(int j = 0; j <= n - 1; j++){
                if(arr[j] == arr[i]) cnt++;
            }

            maxFreq = max(maxFreq, cnt);
            minFreq = min(minFreq, cnt);
        }
    }
    if(maxFreq == minFreq) return -1;
    return maxFreq + minFreq;
}

//Optimal Approach
//Time Complexity: O(n)
//Space Complexity: O(n)
int sumOfHighestAndLowestFrequency_optimal(int arr[], int n){
    unordered_map<int, int> mp;
    for(int i = 0; i <= n - 1; i++) mp[arr[i]]++;

    int maxFreq = 0, minFreq = n;

    // Step 2: Find highest and lowest frequency
    for(auto it: mp){
        int freq = it.second;
        maxFreq = max(maxFreq, freq);
        minFreq = min(minFreq, freq);
    }
    if(maxFreq == minFreq) return -1;
    return maxFreq + minFreq;
}