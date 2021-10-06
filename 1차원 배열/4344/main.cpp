//
//  main.cpp
//  4344
//
//  Created by 홍민아 on 2021/09/29.
//

#include <iostream>
#include <math.h>
using namespace std;

int main() {
    int cnt;
    cin >> cnt;
    int num;
    double avg;
    double a;
    
    
    for(int i = 0; i < cnt; i++){ //테스트 케이스만큼 돌리기
        int student[1000] = {0};
        avg = 0;
        a = 0;
        cin >> num;
        
        
        for(int j = 0; j < num; j++){ // 학생 수 만큼 돌리기
            cin >> student[j];
            avg += student[j]; //합계
        }
        
        avg /= num;
        
        for(int k = 0; k < num; k++){ // 평균 내려고 돌리기
            if(student[k] > avg)
                a++;
        }
        cout << fixed;
        cout.precision(3);
        cout << a/num * 100<< "% \n";
    }
    return 0;
}
