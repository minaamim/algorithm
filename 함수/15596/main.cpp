//
//  main.cpp
//  함수
//
//  Created by 홍민아 on 2021/09/30.
//

#include <iostream>
#include <vector>
using namespace std;

long long sum(vector<int> &a){
    long long sum = 0;
    for(int i = 0; i<a.size(); i++){
        sum += a[i];
    }
    return sum;
}

int main(){
    return 0;
}
