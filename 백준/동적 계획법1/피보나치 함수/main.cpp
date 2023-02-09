//
//  main.cpp
//  동적 계획법1
//
//  Created by 홍민아 on 2021/11/30.
//

#include <iostream>
using namespace std;


int count_num[50] = {0, 1, };

int fibonacci(int n){
    if(n < 2)
        return count_num[n];
    
    else if(count_num[n] == 0)
        count_num[n] = fibonacci(n-1) + fibonacci(n-2);
    
    return count_num[n];
}

int main() {
    int num;
    cin >> num;

    int temp;
    for(int i = 0; i < num; i++){
        cin >> temp;
        if(temp == 0)
            cout << "1 0" << "\n";
        else
            cout << fibonacci(temp-1) << " " << fibonacci(temp) << "\n";
    }
    return 0;
}
