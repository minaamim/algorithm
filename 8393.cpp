//
//  main.cpp
//  8393
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int sum = 0;
    
    for(int i = 1; i < n+1; i++){
        sum += i;
    }
    cout << sum;
    return 0;
}
