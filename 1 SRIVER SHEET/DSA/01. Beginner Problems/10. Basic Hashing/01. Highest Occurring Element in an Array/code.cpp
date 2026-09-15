#include <bits/stdc++.h>
using namespace std;

int HOE_bruteforce(int arr[], int n) {

    int vis[10001] = {0};

    int maxCnt = 0, el = -1;

    for(int i = 0; i < n; i++) {

        int cnt = 0;

        if(vis[arr[i]] == 0) {

            vis[arr[i]] = 1;

            for(int j = 0; j < n; j++) {

                if(arr[i] == arr[j]) {
                    cnt++;
                }
            }

            if(cnt > maxCnt) {
                maxCnt = cnt;
                el = arr[i];
            }
            else if(cnt == maxCnt && arr[i] < el) {
                el = arr[i];
            }
        }
    }

    return el;
}

//using 
int HOE_optimized(int arr[], int n){
    unordered_map<int, int> freq;

    //count all the freq
    for(int i = 0; i < n; i++){
        freq[arr[i]]++;
    }

    int maxCnt = 0, elm = -1;

    //traverse the map
    for(auto it: freq){
        if(it.second > maxCnt){
            maxCnt = it.second;
            elm = it.first;
        } else if(it.second == maxCnt){
            elm = min(it.first, elm);
        }
    }

    return elm;
}