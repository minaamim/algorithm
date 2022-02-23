//
//  main.cpp
//  그리디 알고리즘
//
//  Created by 홍민아 on 2022/02/23.
//
/*
 동전 0
 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 */

#include <iostream>
using namespace std;

int main() {
    int n, k, cnt = 0;
    cin >> n >> k;
    
    int arr[n];
    
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    for(int i = n - 1; i >= 0; i--){
        cnt += k / arr[i];
        k %= arr[i];
    }
    
    cout << cnt;
    
    
    return 0;
}
