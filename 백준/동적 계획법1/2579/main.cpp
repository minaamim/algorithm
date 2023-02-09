//
//  main.cpp
//  2579
//
//  Created by 홍민아 on 2021/12/14.
//

#include <iostream>
#define MAX 301
using namespace std;

int arr[MAX] = {0, };
int dp[MAX] = {0, };

int main() {
    int n;
    cin >> n;
    
    for(int i = 0; i < n; i++)
        cin >> arr[i];
    
    dp[0] = arr[0];
    dp[1] = max(arr[1], arr[0] + arr[1]);
    dp[2] = max(arr[0]+arr[2], arr[1]+arr[2]);
    
    for(int i = 3; i < n; i++){
        dp[i] = max(arr[i] + dp[i-2], arr[i] + arr[i-1] + dp[i-3]);
    }
    
    cout << dp[n-1] << "\n";
    
    return 0;
}
