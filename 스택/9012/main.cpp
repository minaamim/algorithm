//
//  main.cpp
//  9012
//
//  Created by 홍민아 on 2022/09/05.
//

#include <iostream>
#include <stack>
using namespace std;

int main() {
    int num;
    cin >> num;
    

    
    for(int i = 0; i < num; i++) {
        string str;
        cin >> str;
        
        stack<char> st;
        
        for(int j = 0; j < str.length(); j++) {
            if(st.empty() || str[j] == '(')
                st.push(str[j]);
            else if(st.top() == '(')
                st.pop();
        }
        if (st.empty())
            cout << "YES" << "\n";
        else
            cout << "NO" << "\n";
        
    }
    return 0;
}
