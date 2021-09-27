//
//  main.cpp
//  11021
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int num, a, b;
    cin >> num;
    for(int i = 1; i < num+1; i++){
        cin >> a >> b;
        cout << "Case #" << i << ": " << a + b << "\n";
    }
    return 0;
}
