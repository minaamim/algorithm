//
//  main.cpp
//  백트래킹
//
//  Created by 홍민아 on 2021/11/16.
//
// 백트래킹은 완전 탐색 기법에 기본 아이디어가 있음, 대표적으로 DFS(Depth First Search)
// 백트래킹은 비효율적인 경로는 차단하고 목표로 갈 수 있는 가능성이 있는 루트를 검사
// n, m이 주어졌을 때 1-n까지 자연수 중에 중복 없이 m개를 고른 수열

#include <iostream>
using namespace std;
#define MAX 9

int n, m;
int arr[MAX] = {0};
bool visited[MAX] = {0}; //방문 표시


void dfs(int k){
    if(k == m) { //도달했다면
        for(int i = 0; i < m; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    } else {
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                visited[i] = true; //방문 표시
                arr[k] = i;
                dfs(k+1); //더 깊이 들어가기
                visited[i]=false; //백트래킹
            }
        }
    }
}

int main() {
    cin >> n >> m;
    dfs(0);
    return 0;
}
