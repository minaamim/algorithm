//
//  main.cpp
//  Baekjoon
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    for (int i = 1; i < n+1; i++){
        cout << i << "\n"; //endl 사용시 시간초과
    }
    return 0;
}
