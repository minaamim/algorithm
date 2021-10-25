//
//  main.cpp
//  기본수학
//
//  Created by 홍민아 on 2021/10/23.
//

#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    
    cin >> a >> b >> c;

    
    if(c <= b){
        cout << "-1";
    }
    else
        cout << a/(c-b) + 1;
    
    
    
    return 0;
}
