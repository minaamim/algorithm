//
//  main.cpp
//  10989
//
//  Created by 홍민아 on 2021/11/09.
//

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int arr;
    int count[10001] = {0};
    
    for(int i = 0; i < n; i++){
        cin >> arr;
        count[arr]++;
    }
    for(int i = 0; i < 10001; i++){
        for(int j = 0; j < count[i]; j++)
            cout << i << "\n";
    }

    return 0;
}
