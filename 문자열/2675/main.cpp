//
//  main.cpp
//  2675
//
//  Created by 홍민아 on 2021/10/07.
//

#include <iostream>
using namespace std;

int main() {
    int num, a;
    cin >> num;
    string str;
    
    for (int i = 0; i < num; i++){
        a = 0;
        cin >> a >> str;
        
        for(int j = 0; j < str.length(); j++){
            for(int k = 0; k < a ; k++){
                cout << str[j];
            }
        }
        cout << endl;
    }
    
    return 0;
}
