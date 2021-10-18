//
//  main.cpp
//  1157
//
//  Created by 홍민아 on 2021/10/08.
//

#include <iostream>
using namespace std;

int main() {
    string word;
    cin >> word;
    int arr[26] = {0};
    int max = 0;
    int cnt = 0, max_index = 0;
    
    string a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    for(int i = 0; i < word.length(); i++){
        word[i] = toupper(word[i]); //다 대문자로 바꿔주기
        arr[a.find(word[i])]++; //나온 알파벳 카운트 올려주기
    }

    for(int i = 0; i < a.length(); i++){
        if(arr[i] > max){
            max = arr[i];
            max_index = i;
        }
    }
    
    for(int i = 0; i < a.length(); i++){
        if(max == arr[i]) cnt++; //max값이 중복되면 cnt 올려줌
    }
    
    if(cnt>1) cout << "?"; //중복값이 있다면 ? 출력
    else //아니라면 빈도수 높은 알파벳 출력
        cout << a[max_index];
    return 0;
}
