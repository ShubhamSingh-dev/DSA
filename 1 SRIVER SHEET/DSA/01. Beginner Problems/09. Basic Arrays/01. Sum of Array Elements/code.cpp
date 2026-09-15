#include <bits/stdc++.h>
using namespace std;

int sumOfArrayElements(int arr[], int n){
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += arr[i];
    }
    return sum;
}