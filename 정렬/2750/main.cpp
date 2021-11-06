//
//  main.cpp
//  정렬
//
//  Created by 홍민아 on 2021/11/06.
//

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int num[n];
    int temp;
    
    for(int i = 0; i < n; i++)
        cin >> num[i];
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n - 1; j++){
            if(num[j] > num[j+1]){
                temp = num[j];
                num[j] = num[j+1];
                num[j+1] = temp;
            }
        }
    }
    
    for(int i = 0; i < n; i++)
        cout << num[i] << "\n" ;
    
    return 0;
}
