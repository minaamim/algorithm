//
//  main.cpp
//  9184
//
//  Created by 홍민아 on 2021/12/08.
//

#include <iostream>
using  namespace std;

int arr[21][21][21] = {0, };


int w(int a, int b, int c){
    if (a <= 0 or b <= 0 or c <= 0)
        return 1;
    else if(a > 20 or b > 20 or c > 20)
        return w(20, 20, 20);
    else if (arr[a][b][c] != 0) //저장된 값이 있다면
        return arr[a][b][c];
    else if (a < b && b < c) //저장된 값이 없다면
        arr[a][b][c] = w(a, b, c - 1) + w(a, b-1, c - 1) - w(a, b-1, c);
    else
        arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    
    return arr[a][b][c];
}


int main() {
    int a, b, c;
    
    while(true){
        cin >> a >> b >> c;
        
        if( (a == -1) && (b == -1) && (c == -1) )
            break;
        
        cout << "w(" << a << ", " << b << ", " << c << ") = " << w(a, b, c) << "\n";
    }
    
    return 0;
}
