//
//  main.cpp
//  1546
//
//  Created by 홍민아 on 2021/09/29.
//

#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    int test[num];
    int max = 0;
    double avg = 0;
    
    for(int i= 0; i < num; i++){
        cin >> test[i];
        if(max <= test[i])
            max = test[i];
        avg += test[i];
    }
    
    avg = (avg / max * 100) / num;
    cout << avg;
    
    return 0;
}
