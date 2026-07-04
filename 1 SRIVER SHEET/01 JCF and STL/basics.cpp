#include <bits/stdc++.h>
using namespace std;

void explainPair() {
    pair<int, int> pr1 = {2, 8}; //way: 1
    // pair<int, int> pr1 = make_pair(2, 8); //way: 2
    cout << pr1.first << " " << pr1.second << endl;

    pair<int, char> pr2 = {2, 'b'};
    cout << pr2.first << " " << pr2.second << endl;

    //nested pair
    pair<pair<int, char>, int> pr3 = {{1, 'm'}, 4};
    cout << pr3.first.second << endl;
}

void explainVector() {

    vector<int> vec; //vector is dynamic array
    vec.push_back(1);
    vec.push_back(2);
    vec.emplace_back(3); //same as push_back

    vector<int> vec1(5); //intializes 5 zeroes
    vector<int> vec2 = {7, 8}; //initializes vector with 7,8 in it 
    vector<int> vec3 = {5, 9}; //initializes vector with 7,8 in it 
    vector<int> dupVec(vec); //duplicates the vector vec in dupVec
    vector<int> dupVec(vec.begin() + 2, vec.end()); //duplicates the vector vec within range in dupVec


    cout << vec.size() << endl;
    //[1, 2, 3]
    for(int i = 0;i < vec.size(); i++){
        cout << vec[i] << " ";
    }
    cout << endl;

    //! iterator

    // vector<int>::iterator beginItr = vec.begin();
    // vector<int>::iterator endItr = vec.end();
    // for(vector<int>::iterator i = beginItr; i < endItr; i++){
    //     cout << *i << " ";
    // }
    // cout << endl;

    //best way is 
    for(auto i : vec){
        cout << i << " ";
    }
    cout << endl;

    //Reverse iterator
    auto reverseBegin = vec.rbegin();
    auto reverseEnd = vec.rend();
    for(auto i = reverseBegin; i < reverseEnd; i++){
        cout << *i << " ";
    }


    cout << vec.front(); //first element
    cout << vec.back(); //last element
    vec.pop_back(); //pop last element
    vec.erase(vec.begin() + 2); //delete the element 
    vec.erase(vec.begin() + 2, vec.end() - 1); //delete the element in range
    vec.clear(); //clears all
    swap(vec2, vec3); //swaps vector

    vector<int> vec3 = {5, 9, 5, 8, 6, 7};
    vec.insert(vec.begin() + 2, 2); //insert before the selected


}

void explainList() {
    
}

int main() {
    cout << "Learning STL" << endl;

    explainPair();

    return 0;
}