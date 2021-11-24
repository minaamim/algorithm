//
//  main.cpp
//  15651
//
//  Created by 홍민아 on 2021/11/24.
//

#include <iostream>
using namespace std;
#define max 9

int n, m;
int arr[max] = {0};
bool visited[max] = {0};

void dfs(int cnt){
    
    if(cnt == m){
        for(int i = 0; i < m; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for(int i = 1; i <= n; i++){ //중복값을 허용하므로 !visited[i]만 빼준다.
        visited[i] = true;
        arr[cnt] = i;
        dfs(cnt+1);
        visited[i] = false;
    }
    
    
}

int main() {
    cin >> n >> m;
    dfs(0);
    
    return 0;
}
