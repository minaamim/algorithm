//
//  main.cpp
//  5622
//
//  Created by 홍민아 on 2021/10/14.
//

#include <iostream>
using namespace std;

int main() {
    string str;
    cin >> str;
    int total = 0;
    int time[] = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
    
    for(int i = 0; i < str.length(); i++){
        total += time[(str[i] - 'A')];
    }
    
    cout << total;
    
    return 0;
}
