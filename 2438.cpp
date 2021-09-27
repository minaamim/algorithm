//
//  main.cpp
//  2438
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    string a = "*";
    for (int i = 0; i < n; i++){
        cout << a << "\n";
        a += '*';
    }
    return 0;
}
