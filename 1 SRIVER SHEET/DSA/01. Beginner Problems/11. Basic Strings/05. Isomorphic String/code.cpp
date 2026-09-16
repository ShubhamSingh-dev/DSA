#include <bits/stdc++.h>
using namespace std;

bool isIsomorphic(string s, string t) {

    if(s.length() != t.length())
        return false;

    int smap[256] = {0};
    int tmap[256] = {0};

    for(int i = 0; i < s.length(); i++) {

        // Check s -> t mapping
        if(smap[s[i]] != 0 && smap[s[i]] != t[i] + 1)
            return false;

        // Check t -> s mapping
        if(tmap[t[i]] != 0 && tmap[t[i]] != s[i] + 1)
            return false;

        // Store the mapping
        smap[s[i]] = t[i] + 1;
        tmap[t[i]] = s[i] + 1;
    }

    return true;
}

int main(){
    string s = "egg";
    string t = "add";
    cout << isIsomorphic(s, t) << endl;
    return 0;
}