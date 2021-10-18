//
//  main.cpp
//  4673
//
//  Created by 홍민아 on 2021/10/01.
//

#include <iostream>
using namespace std;

bool number[10001];

int d(int n){
    int num = n;
    do{
        num += n % 10;
    } while((n /= 10) != 0);
    return num;
}

void self_number(){
    int temp;
    number[1] = false;
    for(int i = 0; i < 10000; i++){
        if(i < 10000){
            temp = d(i);
            if (temp < 10000)
                number[temp] = true;
                }
    }
}

int main() {
    self_number();
    for(int i = 1; i < 10000; i++){
        if (!number[i])
            cout << i << "\n";
    }
    return 0;
}
