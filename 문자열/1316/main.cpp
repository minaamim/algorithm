//
//  main.cpp
//  1316
//
//  Created by 홍민아 on 2021/10/18.
//

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    string str;
    int cnt = 0;
   
    for(int i = 0; i < n; i++){ //단어의 갯수만큼 돌린다
        cin >> str;
        int flag = true;
        
        for(int j = 0; j < str.length(); j++){ //단어의 길이만큼 돌린다
            for(int k = 0; k < j; k++){
                if(str[j] != str[j-1] && str[j] == str[k]){ //바로 전 알파벳과 같지 않고 그 이전에 중복되는 알파벳이 있다면 브레이크
                    flag = false;
                    break;
                }
            }
        }
        if(flag) cnt++;
    }
    cout << cnt;
    return 0;
}
