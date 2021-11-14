//
//  main.cpp
//  1427
//
//  Created by 홍민아 on 2021/11/14.
//

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    string str;
    cin >> str;
    
    sort(str.begin(), str.end(), greater<char>());
    
    cout << str;
    
    return 0;
}
