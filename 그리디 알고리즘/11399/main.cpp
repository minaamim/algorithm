//
//  main.cpp
//  11399
//
//  Created by 홍민아 on 2022/03/03.
//

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N;
    int sum = 0;
    cin >> N;
    
    int P[N];
    
    for(int i = 0; i < N; i++)
        cin >> P[i];
    
    sort(P, P+N);
    
    for(int i = 0; i < N; i++){
        sum += P[i] * (N-i); //N-i는 각 번호가 더해지는 횟수
    }
    
    cout << sum;
    
    return 0;
}
