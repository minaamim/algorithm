//
//  main.cpp
//  5597
//
//  Created by 홍민아 on 2022/11/22.
//

#include <iostream>
using namespace std;

int main() {
    
    bool arr[31] = {true, false};
    
    for(int i = 1; i <= 28; i++){
        int a;
        cin >> a;
        arr[a] = true;
    }
    

    for(int i = 1; i <= 30; i++){
        if(arr[i] == false){
            cout << i << "\n";
        }
    }
    
    return 0;
}
