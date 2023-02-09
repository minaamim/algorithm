//
//  main.cpp
//  4949
//
//  Created by 홍민아 on 2022/09/08.
//

#include <iostream>
#include <stack>
using namespace std;

int main() {
    while (true) {
        string input;
        cin >> input;
        if(input == ".")
            break;
        
        stack<char> st;
        
        for (int i = 0; i < input.length(); i++) {
            if ( input[i] == '(' || input[i] == '[')
                st.push(input[i]);
            
            else if ( input[i] == ')' ) {
                if ( !st.empty() && st.top() == '(' ) {
                    st.pop();
                }
                else {
                    cout << "no \n";
                    break;
                }
            }
            
            else if ( input[i] == ']' ) {
                if (!st.empty() && st.top() == '[') {
                    st.pop();
                }
                else {
                    cout << "no \n";
                    break;
                }
            }
            
            if (st.empty() && i == input.length() - 2)
                cout << "yes \n";
            else if (!st.empty() && i == input.length() - 2)
                cout << "no \n";
        
        }
    }

    return 0;
}
