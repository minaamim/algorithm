//
//  main.cpp
//  11650
//
//  Created by 홍민아 on 2021/11/15.
//

#include <iostream>
#include <utility>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<pair<long, long>> arr;
    pair<long, long> tmp;
    
    for(int i = 0; i < n; i++){
        cin >> tmp.first >> tmp.second;
        arr.push_back(tmp);
    }
    
    sort(arr.begin(), arr.end());
    for(int i = 0; i < n; i++)
        cout << arr[i].first << " " << arr[i].second << "\n";
    
    
    return 0;
}
