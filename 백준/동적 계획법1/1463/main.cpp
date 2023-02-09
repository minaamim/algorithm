//
//  main.cpp
//  1463
//
//  Created by 홍민아 on 2021/12/23.
//

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;
    
    int dp[N+1];
    
    dp[1] = 0;
    
    for(int i = 2; i <= N; i++){
        dp[i] = dp[i-1] + 1;
        
        if(i % 2 == 0)
            dp[i] = min(dp[i], dp[i/2] + 1);
        if(i % 3 == 0)
            dp[i] = min(dp[i], dp[i/3] + 1);
    }
    
    cout << dp[N];
    
    return 0;
}
