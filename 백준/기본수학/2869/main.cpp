//
//  main.cpp
//  2869
//
//  Created by 홍민아 on 2021/10/27.
//

#include <iostream>
using namespace std;

int main() {
    int a, b, v;
    cin >> a >> b >> v;
    
    int day = 1;
    
    day += (v-a)/(a-b); //(v-a) == 남은 높이, (a-b) == 하루동안 오르는 높이
    
    if((v-a) % (a-b) != 0)
        day++;
    if( a >= v )
        cout << "1";
    else
        cout << day;
    
    return 0;
}
