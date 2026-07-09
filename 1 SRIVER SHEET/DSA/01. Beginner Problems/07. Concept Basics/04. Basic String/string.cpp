//?NOTES
/*
    - string s = "shubham" internally is a array of characters
    - in cpp string is mutable -> can be changed
    - in java string is immutable
    - "" for string , '' for character

    - ASCII value: 'a' to 'z'-> 97 to 122
    - ASCII value: 'A' to 'Z'-> 65 to 90

*/

#include<bits/stdc++.h>
using namespace std;

int main() {
    string s = "shubham";
    //concat
    s = s + 'j'; // Results in "shubhamj"

    //length
    cout << s.length() << endl;

    //indexing
    cout << s[1] << endl; //'h'
    char ch = s[2]; //we need to identify as a character

    //traversal
    for(int i = 0; i < s.length(); i++) {
        cout << s[i] << " ";
    }

    //?Character Array
    char str[] = {'s', 'h', 'u', 'b', 'h', 'a', 'm'};

    //?Substring
    string s1 = "shubham";
    string s2 = s1.substr(0, 4); // "shub"
    string s3 = s1.substr(2); // "ubham" // till last
    string s3 = s1.substr(); // "shubham" //whole string

    //mutable
    string s = "shubham";
    s[0] = 'T'; // "Thubham"
    return 0;

    //Someting to know 
    //during concat always use 
    s = s + 'j'; //Time complexity will be higher internally, some compiler dont notice it but it does take time
    s += 'j'; // Better use this way
}