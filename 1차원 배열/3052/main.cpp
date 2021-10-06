//
//  main.cpp
//  3052
//
//  Created by 홍민아 on 2021/09/29.
//

#include <iostream>
using namespace std;

int main() {
    
    int array[42] = {0};
    int num;
    int sum = 0;
    
    for(int i = 0; i < 10; i++){
        cin >> num;
        array[num%42]++;
    }
    
    for(int i = 0; i < 42; i++){
        if(array[i] != 0)
            sum++;
    }
    
    cout << sum ;
    
    return 0;
}
