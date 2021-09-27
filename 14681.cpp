//
//  main.cpp
//  14681
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int x, y;
    cin >> x >> y;
    
    if (x > 0 && y > 0)
        cout << "1";
    else if ( x < 0 && y > 0)
        cout << "2";
    else if (x < 0 && y < 0)
        cout << "3";
    else
        cout << "4";
    
    return 0;
}
