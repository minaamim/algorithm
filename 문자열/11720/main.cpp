//
//  main.cpp
//  11720
//
//  Created by 홍민아 on 2021/10/07.
//

#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    
    string text;
    cin >> text;
    
    int sum = 0;
    
    for(int i = 0; i < text.length(); i++){
        sum += (text[i] - '0');
    }
    
    cout << sum;
    
    return 0;
}
