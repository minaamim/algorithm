//
//  main.cpp
//  2751
//
//  Created by 홍민아 on 2021/11/07.
//

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int arr[n];
    
    for(int i = 0; i < n; i++)
        cin >> arr[i];
    
    sort(arr[0], arr[n]);
    
    for(int i = 0; i < n; i++)
        cout << arr[i] << "\n" ;
    
    return 0;
}
