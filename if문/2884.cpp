//
//  main.cpp
//  2884
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int h, m;
    cin >> h >> m;
    
    if (m >= 45)
        cout << h << " " << m-45;
    else if ( m < 45 ){
        if (h > 0)
            cout << h - 1 << " " << 15+m;
        else
            cout << "23 " << 15+m;
            
    }
    return 0;
}
