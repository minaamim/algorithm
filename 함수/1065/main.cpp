//
//  main.cpp
//  1065
//
//  Created by 홍민아 on 2021/10/05.
//

#include <iostream>
using namespace std;

void sequence(int num){
    int check = 0;
    int digit1, digit2, digit3;
    
    if (num < 100){
        cout << num;
    }
    else{
        for(int i = 100; i <= num; i++){
            digit1 = i / 100; //100의 자리 -> 100으로 나눈 몫
            digit2 = (i % 100) / 10; //10의 자리 -> 100으로 나눈 나머지를 10으로 나눈 몫
            digit3 = (i % 100) % 10; //1의 자리 -> 100으로 나눈 나머지를 10으로 나눈 나머지
        
            if ( (digit1 - digit2) == (digit2 - digit3) )
                check++;
        }
    
        cout << 99 + check << "\n";
    }
}


int main() {
    int num= 0;
    cin >> num;
    sequence(num);
    return 0;
}
