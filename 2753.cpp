//
//  main.cpp
//  2753
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;

int main(){
    int year;
    cin >> year;
    
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        cout << "1";
    else
        cout << "0";
    
    return 0;
    
}
