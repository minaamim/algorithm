//
//  main.cpp
//  1436
//
//  Created by 홍민아 on 2021/11/05.
//

#include <iostream>
using namespace std;

int find(int n){
    int end = 666;
    int series = 0;
    string target;
    
    while(true){
        target = to_string(end);
        for(int i = 0; i < target.length() - 2; i++)
            if(target[i] == '6' && target[i+1] == '6' && target[i+2] == '6'){
                series++;
                if(series == n)
                    return end;
                break;
            }
        end++;
    }
}

int main() {
    int n;
    cin >> n;
    
    cout << find(n);
    return 0;
}
