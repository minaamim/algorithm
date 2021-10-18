//
//  main.cpp
//  10809
//
//  Created by 홍민아 on 2021/10/07.
//

#include <iostream>
using namespace std;
int main() {
    string word;
    cin >> word;
    
    string alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    for(int i = 0; i < alphabet.length(); i++){
        cout << (int)word.find(alphabet[i]) << " ";
    }
    
    system("pause");
    return 0;
}
