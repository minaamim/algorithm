//
//  main.cpp
//  15652
//
//  Created by 홍민아 on 2021/11/25.
//

#include <iostream>
using  namespace std;
#define max 9

int n, m;
int arr[max] = {0};
bool visited[max] = {0};

void dfs(int num, int k){
    
    if(k==m){
        for(int i = 0; i < m ; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
        for(int i = num; i <= n; i++){
            visited[i] = true;
            arr[k] = i;
            dfs(i, k+1);
            visited[i] = false;
        }
    
}

int main() {
    cin >> n >> m;
    dfs(1, 0);
    return 0;
}
