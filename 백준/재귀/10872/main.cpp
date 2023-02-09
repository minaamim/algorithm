//
//  main.cpp
//  재귀
//
//  Created by 홍민아 on 2021/11/01.
//

#include <iostream>
using namespace std;

int factorial(int n){
    if(n<=1)
        return 1;
    else
        return n * factorial(n-1);
}

int main() {
    int n;
    cin >> n;
    
    cout << factorial(n);
    
    return 0;
}
