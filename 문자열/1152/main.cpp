//
//  main.cpp
//  1152
//
//  Created by 홍민아 on 2021/10/11.
//

#include <iostream>
using namespace std;

int main() {
    string word;
    getline(cin, word);
    int cnt = 1;
    
    for(int i = 0; i < word.length(); i++){
        if(word[i] == ' '){
            cnt++;
        }
    }
    
    if(word[0] == ' ') //처음이 공백이면 -1
        cnt--;
    
    if(word[word.length() -1] == ' ') //마지막이 공백이면 -1
        cnt--;
    
    cout << cnt;
    return 0;
}
