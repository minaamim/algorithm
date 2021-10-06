//
//  main.cpp
//  8958
//
//  Created by 홍민아 on 2021/09/29.
//

#include <iostream>
using namespace std;

int main() {
    int num;
    string quiz ="";
    cin >> num;
    int cnt, total;
    
    for(int i = 0; i < num; i++){
        cin >> quiz;
        
        cnt = 0; //돌아올 때마다 다시 기본값 0으로
        total = 0;
        
        for(int j = 0; j < quiz.length(); j++){
            if(quiz[j] == 'O'){
                cnt++;
                total += cnt;
            }
            else{
                cnt = 0; // X 나오면 0으로
            }
        }
        cout << total << "\n";
        quiz = "";
    }
    
    return 0;
}
