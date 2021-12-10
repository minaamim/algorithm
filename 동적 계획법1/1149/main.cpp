//
//  main.cpp
//  1149
//
//  Created by 홍민아 on 2021/12/09.
//

#include <iostream>
using namespace std;

int home[1000][3];

int main() {
    int N;
    cin >> N;
    int R, G, B;
    
    home[0][0] = 0;
    home[0][1] = 0;
    home[0][1] = 0;
    
    for(int i = 1; i <= N; i++){
        cin >> R >> G >> B;
        
        home[i][0] = min(home[i-1][1], home[i-1][2]) + R; //현재를 R로 둘 때
        home[i][1] = min(home[i-1][0], home[i-1][2]) + G;
        home[i][2] = min(home[i-1][0], home[i-1][1]) + B;
    }
    
    cout << min(home[N][0], min(home[N][1], home[N][2]));
    
    return 0;
}
