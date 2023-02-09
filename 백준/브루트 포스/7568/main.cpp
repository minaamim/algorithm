//
//  main.cpp
//  7568
//
//  Created by 홍민아 on 2021/11/03.
//

#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    int people[num][2];
    int count;
    
    for(int i = 0; i < num; i++){
        cin >> people[i][0] >> people[i][1];
    }
    
    for(int i = 0; i < num; i++){
        count = 1;
        for(int j = 0; j < num; j++){
            if(people[i][0] < people[j][0] && people[i][1] < people[j][1])
                count++;
        }
        cout << count << " ";
        
    }
    
    return 0;
}
