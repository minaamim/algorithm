//
//  main.cpp
//  브루트 포스
//
//  Created by 홍민아 on 2021/11/02.
//

#include <iostream>
#include <math.h>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int num[n];
    int a;
    
    for(int i = 0; i < n; i++){
        cin >> a;
        num[i] = a;
    }
    int mx = 0;
    
    for(int i = 0; i < n-2; i++){
        for(int j = i + 1; j < n - 1; j++){
            for(int k = j + 1; k < n; k++){
                int sum = num[i] + num[j] + num[k];
                
                if(sum > mx && sum <= m){
                    mx = sum;
                }
            }
        }
    }
    
    cout << mx;
    
    return 0;
}
