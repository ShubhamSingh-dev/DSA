#include <bits/stdc++.h>
using namespace std;

long long int sumOfArray(int arr[], int n){
    if(n == 0) return 0;
    return arr[n - 1] + sumOfArray(arr, n - 1);
}

int main(){
    int arr[] = {1, 2, 3, 4, 5};
    int n = sizeof(arr);
    
    cout << sumOfArray(arr, n);

    return 0;
}