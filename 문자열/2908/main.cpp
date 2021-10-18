//
//  main.cpp
//  2908
//
//  Created by 홍민아 on 2021/10/11.
//

#include <iostream>
using namespace std;

int main() {
    string arr1, arr2;
    cin >> arr1 >> arr2;
    string bigger;
    
    for(int i = 2; i >= 0 ; i--){
        if(arr1[i] > arr2[i]){
            bigger = arr1;
            break;
        }
        else if(arr1[i] < arr2[i]){
            bigger = arr2;
            break;
        }
    }
    
    cout << bigger[2] << bigger[1] << bigger[0];
    return 0;
}
