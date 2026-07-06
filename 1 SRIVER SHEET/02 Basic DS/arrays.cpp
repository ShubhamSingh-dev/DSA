#include <bits/stdc++.h>
using namespace std;

int sum(int arr[], int n) {
    int ans = 0;
    for(int i = 0; i < n; i++ ){
        ans = ans + arr[i];
    }
    return ans;
}

int countOfOdd(int arr[], int n){
    int count = 0;
    for(int i=0; i < n; i++){
        if(arr[i] % 2 != 0){
            count++;
        }
    }
    return count;
}

void reverseArray(int arr[], int n){
    //Using Temp array // TC - 0(n) and SC - 0(n)
    // int temp[n];
    // for(int i = 0; i < n; i++){
    //     temp[n - 1 - i] = arr[i];
    // }
    // for(int i = 0; i < n; i++){
    //     arr[i] = temp[i];
    // }

    //two pointer approach // TC - 0(n) and SC - 0(1)
    int left = 0;
    int right = n - 1;
    while(left < right){
        swap(arr[left], arr[right]);
        left++;
        right--;
    }
}

bool checkIfArraySorted(int arr[], int n){
    for(int i = 0; i < n - 1; i++){
        if(arr[i] > arr[i + 1]){
            return false;
        }  
    }
    return true;
}

int main() {
    // Array store same datatype and the memory location is contagious in memory
    // Contaiguous means 101,102,103 ....
    // indexing [0, .... , N - 1]
    // 2D array : Array of array [ [], [], [] ] 

    //? Sum of array elements
    int arr[5] = {1, 2, 3, 4, 5};
    cout << sum(arr, 5) << endl;

    //? Count of odd elements
    cout << countOfOdd(arr, 5) << endl;

    //? Reverse array
    reverseArray(arr, 5);
    for(int i = 0; i < 5; i++){
        cout << arr[i] << " ";
    }
    cout << endl;

    //? Check if array is sorted
    cout << checkIfArraySorted(arr, 5) << endl;
    return 0;
}