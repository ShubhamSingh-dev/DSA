#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

int SecondHighestOccuringElement_bruteforce (int arr[], int n ){
    int vis[10001] = {0};
    int el1 = -1, el2 = -1;
    int el1Freq = 0, el2Freq = 0;


    for(int i = 0; i <= n - 1; i++){
        if(vis[arr[i] == 0]){
            vis[arr[i]] = 1;
            int cnt = 0;

            //count freq
            for(int j = 0; j <= n - 1; j++){
                if(arr[j] == arr[i]) cnt++;
            }

            //New highest
            if(cnt > el1Freq){
                el2 = el1;
                el2Freq = el1Freq;
                el1= arr[i];
                el1Freq = cnt;
            } 
            //new secondHighest
            else if(cnt > el2Freq){
                el2 = arr[i];
                el2Freq = cnt;
            } 
            //tie for highest
            else if(cnt == el1Freq && arr[i] < el1){
                el1 = arr[i];
            } 
            //Tie for second highest
            else if(cnt == el2Freq && arr[i] < el2){
                el2 = arr[i];
            }
        }
    }

    return el2;
}

int SecondHighestOccuringElement_optimal(int arr[], int n){
    unordered_map<int, int> mp;

    //count freq
    for(int i; i < n; i++){
        mp[arr[i]]++;
    }

    int el1 = -1; //element having highest frequency
    int el1Freq = -1;// it's frequency
    
    int el2 = -1; //element having second-highest frequency
    int el2Freq = -1; //its frequency
    
    // Step 2: Find highest and second highest frequency
    for(auto it: mp){
        int element = it.first;
        int freq = it.second;

        // Case 1: New highest
        if(freq > el1Freq){
            el2 = el1;
            el2Freq = el1Freq;

            el1 = element;
            el1Freq = freq;
        }

        // Case 2: Same frequency as highest
        else if(freq == el1Freq){

            if(element < el1){
                el2 = el1;
                el2Freq = el1Freq;

                el1 = element;
            }
            
        }

        // Case 3: New second highest
        else if (freq > el2Freq) {
            el2 = element;
            el2Freq = freq;
        }

        // Case 4: Same frequency as second highest
        else if(freq == el2Freq && element < el2) {

            el2 = element;
        }

    }

    return el2;
}