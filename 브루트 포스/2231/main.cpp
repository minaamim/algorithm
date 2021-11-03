//
//  main.cpp
//  2231
//
//  Created by 홍민아 on 2021/11/03.
//

#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    int sum;
    int temp;
    
    for(int i = 0; i < num; i++){
        sum = i;
        temp = i;
        
        while(temp){
            sum += temp % 10; // 각 자릿수 더하기
            temp /= 10;
        }
        
        if(sum == num){
            cout << i ;
            return 0; //끝내기
        }
    }
    
    cout << "0" ; //없다면 0 출력
    
    return 0;
}
