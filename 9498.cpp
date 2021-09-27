//
//  main.cpp
//  if
//
//  Created by 홍민아 on 2021/09/23.
//

#include <iostream>
using namespace std;
int main() {
    int test;
    cin >> test;
    
    if (90 <= test)
        cout << "A";
    else if (test >= 80)
        cout << "B";
    else if (test >= 70)
        cout << "C";
    else if (test >= 60)
        cout << "D";
    else
        cout << "F";
    
    return 0;
        
}
