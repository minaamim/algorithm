//
//  main.cpp
//  1110
//
//  Created by 홍민아 on 2021/09/27.
//

#include <iostream>
using namespace std;

int main() {
    int a, n;
    cin >> n;
    int count = 0;
    
    a =n;
    
    while(true){
    
        a = (a % 10) * 10 + ((a % 10) + (a / 10)) % 10;
        count++;
        
        if(a==n)
            break;
    }
    
    cout << count;
    return 0;
}
