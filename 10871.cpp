//
//  main.cpp
//  10871
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main() {
    int n, x;
    cin >> n >> x;
    int val;
    for(int i = 0; i < n; i++){
        cin >> val;
        if (val < x)
            cout << val << " ";
    }
    return 0;
}
