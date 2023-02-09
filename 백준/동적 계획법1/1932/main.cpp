//
//  main.cpp
//  1932
//
//  Created by 홍민아 on 2021/12/11.
//

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n;
    int max_num = 0;
    cin >> n;
    
    int triangle[501][501];
    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= i; j++)
            cin >> triangle[i][j];
    }
    
    for(int i = 2; i <= n; i++){
        for(int j = 1; j<=i; i++){
            if(j==1)
                triangle[i][j] += triangle[i-1][j];
            else if (j==i)
                triangle[i][j] += triangle[i-1][j-1];
            else
                triangle[i][j] += max(triangle[i-1][j], triangle[i-1][j-1]);
        }
    }
    
    for(int i = 1; i <= n; i++){
        if(triangle[n][i] > max_num)
            max_num = triangle[n][i];
    }

    cout << max_num ;
    
    return 0;
}
