//
//  main.cpp
//  1330
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    
    if (a > b)
        cout << ">";
    else if(a < b)
        cout << "<";
    else
        cout << "==";
    
    return 0;
        
}
