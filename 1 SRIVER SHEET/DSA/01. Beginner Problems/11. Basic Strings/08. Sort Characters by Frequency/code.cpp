#include <bits/stdc++.h>
#include <utility>
#include <vector>
using namespace std;

bool comparator(pair<int, char> a, pair<int, char> b){
    if(a.first > b.first) return true;
    if(a.first < b.first) return false;
    return a.second < b.second;
    
}

vector<char> sortByFreq(string s){
    pair<int, char> freq[26];
    for(int i = 0; i < 26; i++){
        freq[i] = {0, i + 'a'};
    }

    //count freq of each char
    for(char ch: s){
        freq[ch - 'a'].first++;
    }

    sort(freq, freq + 26, comparator);

    vector<char> ans;
    for(int i = 0; i < 26; i++){
        if(freq[i].first > 0){
            ans.push_back(freq[i].second);
        }
    }
    return ans;
}