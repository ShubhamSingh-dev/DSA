#include <bits/stdc++.h>
#include <utility>
using namespace std;

void reverse(int arr[], int n){
    int left = 0, right = n - 1;
    while(left < right){
        swap(arr[left], arr[right]);
        left++;
        right--;
    }
}