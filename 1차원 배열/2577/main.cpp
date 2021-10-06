//
//  main.cpp
//  2577
//
//  Created by 홍민아 on 2021/09/29.
//

#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    int array[10] = {0};
    
    int num = a * b * c;
    
    while(num != 0){
        array[num % 10]++;
        num /= 10;
    }
    
    for(int i = 0; i < 10; i++){
        cout << array[i] << "\n";
    }
    
    return 0;
}
