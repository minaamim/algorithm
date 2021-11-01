//
//  main.cpp
//  2477
//
//  Created by 홍민아 on 2021/11/01.
//

#include <iostream>
using namespace std;

void star(int i, int j, int n){
    if( i / n % 3 == 1 && j / n % 3 == 1)
        cout << " ";
    else if (n / 3 == 0)
        cout << "*";
    else
        star(i, j, n / 3);
}

int main() {
    int n;
    cin >> n;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            star(i, j, n);
        }
        cout << "\n";
    }
    
    return 0;
}
