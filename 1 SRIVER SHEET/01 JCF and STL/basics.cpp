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
    //For vector internal ds is array
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
    //For vector internal ds is linkedList
    // The difference between vector amd list is List allows push in front
    list<int> ls = {6, 7};
    ls.push_front(5);
    ls.emplace_front(4); //does the same as push_front
    for(auto it: ls){
        cout << it << " ";
    }
}

void explainDeque() {
    //same as list
    deque<int> dq = {6, 7};
    dq.push_front(5);
    dq.emplace_front(4);
}

void explainStack() {
    //folows LIFO
    stack<int> st;
    st.push(1);
    st.push(2);
    st.push(3);
    st.pop(); //removes the top element
    st.top(); //gets the top element

    //there is no iteration in stack you pop and top
    //what to do then 
    while(st.empty() == false){
        cout << st.top() << " ";
        st.pop();
    }
}

void explainQueue() {
    //folows FIFO
    queue<int> q;
    q.push(1);
    q.push(2);
    q.push(3);
    q.pop(); //removes the first element
    q.front(); //gets the first element

    while(q.empty() == false){
        cout << q.front() << " ";
        q.pop();
    }
}

void explainPriorityQueue() {
    //stores the highest elem at the top
    //internally uses maxHeap
    priority_queue<int> pq;
    pq.push(5);
    pq.push(2);
    pq.push(10);
    
    while(pq.empty() == false){
        cout << pq.top() << " ";
        pq.pop();
        cout << endl;
    } //prints 10 5 2

    //priority queue with custom comparator smallest priority
    priority_queue<int, vector<int>, greater<int>> pq1;
    priority_queue<char, vector<char>, greater<char>> pq2;

    pq1.push(5);
    pq1.push(2);
    pq1.push(10);
    
    while(pq1.empty() == false){
        cout << pq1.top() << " ";
        pq1.pop();
        cout << endl;
    } //prints 2 5 10
}

void explainSet() {
    //stores only unique elem in ascending order
    set<int> st;
    st.insert(5);
    st.insert(2);
    st.insert(5);
    st.insert(7);
    
    for(auto it: st){
        cout << it << " ";
    } //prints 2 5

    //what if we want to find 5
    //iterator
    // make sure st.end() means after the last element
    auto it = st.find(5);
    if(it != st.end()){
        cout << "Found" << endl;
        cout << *it << endl;
    }

    //to count
    cout << st.count(5) << endl;

    //erase
    st.erase(5);
    auto it = st.end();
    it--;it--;
    st.erase(it); //erases that position
    st.erase(it, st.end()); //erases that range

    //return an iterator that points to an element
    //that is >= number given
    auto it = st.lower_bound(4); //prints 5

    //return an iterator that points to an element
    //that is > number given
    auto it = st.upper_bound(5); //prints 7
}

void explainMuliSet() {
    //stores multiple elem
    multiset<int> ms;
    ms.insert(5);
    ms.insert(2);
    ms.insert(5);
    ms.insert(5);   
    ms.insert(7);   

    auto it = ms.erase(5); //erases all
    auto it = ms.erase(ms.find(5)); //erases only one
    for(auto it: ms){
        cout << it << " ";
    }
}

void explainUnorderedSet() {
    //no order basically random
    // but store unique elem
    // better time complexity O(1)
    // lowerbound and upperbound not available
    unordered_set<int> us;
    us.insert(5);
    us.insert(2);
    us.insert(5);
    us.insert(5);   
    us.insert(7);

    auto it = us.find(11);
}

void explainMap() {
    //key value pair
    map<int, string> mp;
    //stores in asscending order of key
    mp.insert({4, "mno"});
    mp[1] = "abc";
    mp[2] = "xyz";
    mp.insert({3, "pqr"});
    
    for(auto it: mp){
        cout << it.first << "->" << it.second << endl;
    }

    //iterator
    auto it = mp.find(3);
    if(it != mp.end()){
        cout << "Found" << endl;
        cout << it->second << endl;
    }

    //unordered map -> no order // better to use
    unordered_map<int, string> ump;
}

void explainMultimap() {
    //stores multiple values for same key
    multimap<int, string> mp;
    mp.insert({4, "mno"});
    mp.insert({1, "abc"});
    mp.insert({2, "xyz"});
    mp.insert({3, "pqr"});
    mp.insert({3, "pqr"});
    
    for(auto it: mp){
        cout << it.first << "->" << it.second << endl;
    }

    auto it = mp.equal_range(3); //return pair of iterator
    for(auto i = it.first; i != it.second; i++){
        cout << i->second << " ";
    }
    // doing (*it).first and it->first is same 
}

void explainSort() {
    int arr[5] = {2, 5, 1, 6, 3};
    sort(arr, arr + 5); //ascending order
    sort(arr + 1, arr + 4);//range
    sort(arr, arr + 5, greater<int>()); //descending order

    vector<int> vec = {2, 5, 1, 6, 3};
    sort(vec.begin(), vec.end()); //entire vector sorted

}

void explainAccumulate() {
    int arr[5] = {2, 5, 1, 6, 3};
    int sum = accumulate(arr, arr + 5, 0); //0 is initial value // 0 + 2 + 5 + 1 + 6 + 3
    int sum = accumulate(arr, arr + 5, 13); //13 + 2 + 5 + 1 + 6 + 3
}
void explainCount() {
    int arr[5] = {2, 5, 5, 6, 3};
    int cnt = count(arr, arr + 5, 5); //2
}

void explainFind() {
    int arr[5] = {2, 5, 5, 6, 3};
    auto it = find(arr, arr + 5, 5); //returns iterator
}

void explainNext_permutation() {
    string str = "abc";
    do{
        cout << str << endl;
    }while(next_permutation(str.begin(), str.end()));
    //abc
    //acb
    //bac
    //bca
    //cab
    //cba
    //gives in sorted order
    //so if doing 
    string str1 = "acb";
    do{
        cout << str1 << endl;
    }while(next_permutation(str1.begin(), str1.end()));
    //acb
    //abc

    // if doing previous permutation
    string str2 = "bac";
    do{
        cout << str2 << endl;
    }while(prev_permutation(str2.begin(), str2.end()));
    
}

void explainMaxElement() {
    int arr[5] = {2, 5, 10, 6, 3};
    auto it = max_element(arr, arr + 5); // returns iterator
    auto it = min_element(arr, arr + 5); // returns iterator
    cout << *it << endl;
}

void explainReverse() {
    int arr[5] = {2, 5, 10, 6, 3};
    reverse(arr, arr + 5);
}

bool internalComparator(pair<int,int> el1, pair<int, int> el2){
    if(el1.second > el2.second) return true;
    if(el1.second < el2.second) return false;
    if(el1.first < el2.first) return true;
    return false;

}

void explainComparator() {
    //there is an internal comparator in c++ which compares elem 1 with elem 2
    pair<int, int> arr[] = {{1, 6}, {2, 3}, {3, 4},{4, 4}, {4, 9}};
    // sort it according to second element
    sort(arr, arr+5, internalComparator);
    for(int i=0;i<5;i++){
        cout << "{" << arr[i].first << "," << arr[i].second << "} ";
    }
}
int main() {
    cout << "Learning STL" << endl;

    explainPair();

    return 0;
}