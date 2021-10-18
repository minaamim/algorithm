//
//  main.cpp
//  2941
//
//  Created by 홍민아 on 2021/10/14.
// 시간 초과..

#include <iostream>
#include <string>
using namespace std;

int main() {
    int index;
    string str;
    cin >> str;
    string arr[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    
    for(int i = 0; i < str.length(); i++){
        while(true){
            index = str.find(arr[i]);
            if(index == string::npos)
                break;
            
            str.replace(index, arr[i].length(), "a");
        }
    }
    
    cout << str.length();
    return 0;
}
