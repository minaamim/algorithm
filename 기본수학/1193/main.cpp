//
//  main.cpp
//  1193
//
//  Created by 홍민아 on 2021/10/27.
// 분수찾기

#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    
    int i = 1;
    int d = 0;
    
    for(int sum = 0; sum +i < num; i++){
        sum += i;
        d = num - sum;
    }
    
    if(i%2 == 1)
        cout << i - d + 1 << "/" << d;
    else
        cout << d << "/" << i - d + 1;
    
    return 0;
}
