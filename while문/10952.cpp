//
//  main.cpp
//  10952
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int a, b;
    
    while (true){
        cin >> a >> b;
        if ( a == 0 && b == 0)
            break;
        cout << a + b << "\n";
    }
    return 0;
}
