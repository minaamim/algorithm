//
//  main.cpp
//  11650
//
//  Created by 홍민아 on 2021/11/16.
//

#include <iostream>
using namespace std;
#define MAX 9

int n, m;
int arr[MAX] = {0};
bool visited[MAX] = {0}; //방문 표시


void dfs(int num, int k){
    if(k == m) { //도달했다면
        for(int i = 0; i < m; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return; //함수의 즉시 종료 및 특정 값을 넘겨줄 때
    }
        for(int i = num; i <= n; i++){
            if(!visited[i]){
                visited[i] = true; //방문 표시
                arr[k] = i;
                dfs(i+1, k+1); //더 깊이 들어가기
                visited[i]=false; //백트래킹
            }
        }
    
}

int main() {
    cin >> n >> m;
    dfs(1, 0);
    return 0;
}
