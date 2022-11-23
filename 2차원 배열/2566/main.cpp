//
//  main.cpp
//  2차원 배열
//
//  Created by 홍민아 on 2022/11/22.
//

#define max_num 81

#include <iostream>
using namespace std;

int main(int argc, const char * argv[]) {
    
    int max = 0;
    int row = 0;
    int column = 0;
    int arr[max_num][max_num] = {0};
    
    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            cin >> arr[i][j];
            if(arr[i][j] > max){
                max = arr[i][j];
                row = i;
                column = j;
            }
        }
    }
    
    cout << max << "\n" << row + 1 << " " << column + 1;

    return 0;
}
