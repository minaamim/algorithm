//
//  main.cpp
//  스택
//
//  Created by 홍민아 on 2022/09/01.
//

#include <iostream>
using namespace std;

int stackSize;
int a[10001];

void push(int x) {
    a[stackSize] = x;
    stackSize++;
}

int pop() {
    if(stackSize == 0)
        return -1;
    
    int t = a[stackSize - 1];
    stackSize--;
    return t;
}

int size() {
    return stackSize;
}


int empty() {
    if(stackSize == 0)
        return 1;
    else
        return 0;
}

int top() {
    if(stackSize == 0)
        return -1;
    return a[stackSize - 1];
}

int main() {
    
    int n;
    cin >> n;
    
    while(n--) {
        string str;
        cin >> str;
        
        if(str == "push") {
            int n;
            cin >> n;
            push(n);
        }
        
        if(str == "pop") {
            cout<<pop() << "\n";
        }
        
        if(str == "top") {
            cout << top() << "\n";
        }
        
        if(str == "size") {
            cout << size() << "\n";
        }
        
        if(str == "empty") {
            cout << empty() << "\n";
        }
    }
    return 0;
}
