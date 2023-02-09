//
//  main.cpp
//  10773
//
//  Created by 홍민아 on 2022/09/05.
//

#include <iostream>
using namespace std;

int s = 0; //stackSize
int arr[100000] = {0};

void push(int n) {
    arr[s] = n;
    s++;
}

void pop() {
    s--;
}

int main() {
    
    int k;
    cin >> k;
    
    for(int i = 0; i < k; i++) {
        int a;
        cin >> a;
        if(a == 0) {
            pop();
        }
        else {
            push(a);
        }
    }
    
    int sum = 0;
    
    for(int i = 0; i < s; i++) {
        sum += arr[i];
    }
    
    cout << sum;
    
    return 0;
}
