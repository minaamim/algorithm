//
//  main.cpp
//  9461
//
//  Created by 홍민아 on 2021/12/08.
//

#include <iostream>
using namespace std;

long long arr[101] = {0, 1, 1, };

long long P(int n){
    if (n < 3)
        return arr[n];
    else  if (arr[n] == 0)
        arr[n] = P(n-2) + P(n-3);
    return arr[n];
    
}

int main() {
    int T;
    cin >> T;
    int N;
    
    for(int i = 0 ; i < T; i++){
        cin >> N;
        cout << P(N) << "\n";
    }
    return 0;
}
