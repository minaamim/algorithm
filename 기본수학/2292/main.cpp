//
//  main.cpp
//  2292
//
//  Created by 홍민아 on 2021/10/25.
//

#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    int cnt = 1, inc = 6, standard = 1;
    
    while(true){
        if(num <= standard){
            cout << cnt;
            break;;
        }
        standard += inc;
        inc += 6;
        cnt++;
    }
    return 0;
}
