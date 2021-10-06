//
//  main.cpp
//  1차원 배열
//
//  Created by 홍민아 on 2021/09/29.
//

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    int array[n];
    
    for(int i = 0; i < n; i++){
        cin>> array[i];
    }
    
    sort(array, array + n);
    cout << array[0] << " " << array[n-1];
    
    return 0;
}
