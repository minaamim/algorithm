//
//  main.cpp
//  10870
//
//  Created by 홍민아 on 2021/11/01.
//

#include <iostream>
using namespace std;

int fibonacci(int n){
    if(n == 0)
        return 0;
    else if (n == 1)
        return 1;
    else
        return fibonacci(n - 1) + fibonacci(n-2);
}

int main() {
    int n;
    cin >> n;
    
    cout << fibonacci(n);
    return 0;
}
