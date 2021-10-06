//
//  main.cpp
//  2562
//
//  Created by 홍민아 on 2021/09/29.
//

#include <iostream>
using namespace std;

int main() {
    
    int array[9];
    int max = 0;
    int index = 0;
    
    for(int i = 0; i < 9; i++){
        cin >> array[i];
        if(max <= array[i]){
            max = array[i];
            index = i;
        }
    }
    
    cout << max << "\n" << index + 1;
    
    return 0;
}
