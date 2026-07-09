//?NOTES
/*
    - The reason we use hashing is to cache data
    - We use hashing to store data in a way that allows for quick and easy retrieval for future use 
    - Imagine an array with duplicates elements ad we need to find the frequency of each element
    - We can use hashing to store the frequency of each element in a hash table
    - Caching use hashing internally

    - The work to find the freq is called precomputation
    - if we are using " array " as the hashing datastructure inside the main() function, the largest size woukd be 10^6 only
      outside as global variable it will be 10^7 for int and 10^8 for boolean

    //Working with ASCII values

    - ASCII value of 'a' is 97
    - ASCII value of 'z' is 122
    - ASCII value of 'A' is 65

    - to store characters in an array, we can use ASCII values
    - how the 'a' -> 97, so lets say we do 'a' - 'a' = 97 - 97 = 0
      so at index 0 we can store 'a' freq
      similarly 'b' - 'a' = 98 - 97 = 1 so at index 1 we can store 'b' freq
      so, we loop through are string and access the character s[i] and subtract it with 'a'
      s[i] - 'a' will give us the index in the array

      NOTE : 'a' to 'z' is 26 characters
            'A' to 'Z' is 26 characters 
            'a' to 'z' + 'A' to 'Z' is 52 characters
                  
    //What if size >10^6 wont use array

    - If the size is greater than 10^6, we can use map //TreeMap or unordered_map //HashMap
    - map takes o(logn) time to do anything the element, this best,worst,avg
    - unordered_map takes o(1) time to do anything the element, this best,avg
       might take o(n) time to do anything the element, this worst
       best to use unordered_map over map

*/

#include<bits/stdc++.h>
using namespace std;

int hashArrayInt() {
    int n, arr[n];
    int maxNum = INT_MIN;
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> arr[i];
        maxNum = max(maxNum, arr[i]);
    }

    int hash[maxNum + 1] = {0}; //intialize with all zeros
    for (int i = 0; i < n; i++){
        hash[arr[i]]++;
        //Precomputation completed here
    }

    return 0;
}

char hashArrayChar() {
    string s;
    cin >> s;
    int hash[26] = {0};
    for (int i = 0; i < s.length(); i++){
        hash[s[i] - 'a']++;
    }
    return 0;
}

int usingMap() {
    int n, arr[n];
    cin >> n;
    map<int, int> mp;
    for (int i = 0; i < n; i++){
        cin >> arr[i];
        mp[arr[i]]++;
    }
    
}

 int mostFrequentElement(vector<int> &nums) {
        
        // Variable to store the size of array
        int n = nums.size();
        
        // Variable to store maximum frequency
        int maxFreq = 0; 
        
        /* Variable to store element 
        with maximum frequency */
        int maxEle;
        
        // HashMap
        unordered_map<int, int> mpp;
        
        // Iterating on the array
        for (int i = 0; i < n; i++) {
            // Updating hashmap 
            mpp[nums[i]]++;
        }
            
        // Iterate on the map
        for(auto it : mpp) {
            int ele = it.first; // Key
            int freq = it.second; // Value
            
            if(freq > maxFreq) {
                maxFreq = freq;
                maxEle = ele;
            }
            else if(freq == maxFreq) {
                maxEle = min(maxEle, ele);
            }
        }
        
        // Return the result
        return maxEle;
    }


 /* Function to get the second highest 
    occurring element in array */
    int secondMostFrequentElement(vector<int> &nums) {
        
        // Variable to store the size of array
        int n = nums.size();
        
        /* Variable to store maximum frequency
        and second Max frequency */
        int maxFreq = 0;
        int secMaxFreq = 0;
        
        /* Variable to store elements with most 
        and second most frequency */
        int maxEle = -1, secEle = -1;
        
        // Visited array
        vector<bool> visited(n, false);
        
        // First loop
        for(int i = 0; i < n; i++) {
            // Skip second loop if already visited
            if(visited[i]) continue;
            
            /* Variable to store frequency
            of current element */
            int freq = 0;
            
            // Second loop
            for(int j = i; j < n; j++) {
                if(nums[i] == nums[j]) {
                    freq++;
                    visited[j] = true;
                }
            }
            
            /* Update variables if new element  
            having highest frequency or second
            highest frequency is found */
            if(freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = nums[i];
            } 
            else if(freq == maxFreq) {
                maxEle = min(maxEle, nums[i]);
            }
            else if(freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = nums[i];
            }
            else if(freq == secMaxFreq) {
                secEle = min(secEle, nums[i]);
            }
            
        }
        
        // Return the result
        return secEle;
    }
int main() {
    return 0;
}