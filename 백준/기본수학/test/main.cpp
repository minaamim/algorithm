//
//  main.cpp
//  test
//
//  Created by 홍민아 on 2022/05/07.
//

#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string sources[] = {"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"};
    char mbti[8] = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    int result[8] = {0};

    survey.push_back(survey.front())

    for(int i = 0; i < survey.size(); i++){
        for(int j = 0; j < 8; j++){
            switch(choices[i]){
                    
            case 1:
            if(mbti[j] == survey[i].front()){
                result[j] += 3;
            }
            break;

            case 2:
            if(mbti[j] == survey[i].front()){
                result[j] += 2;
            }
            break;

            case 3:
                    if(mbti[j] == survey[i].front()){
                        result[j] += 1;
                    }
            break;

            case 4:
            break;

            case 5:
            if(mbti[j] == survey[i].back()){
                result[j] += 1;
            }
            break;

            case 6:
            if(mbti[j] == survey[i].back()){
                result[j] += 2;
            }
            break;

            case 7:
            if(mbti[j] == survey[i].back()){
                result[j] += 3;
            }
            break;
          }
        }
    }
    
    string answer = "";

    for(int i = 0; i < 8; i++){
        cout << result[i];
    }

    for(int i = 0; i < 8; i++){
        if(result[i] < result[i + 1])
            answer += mbti[i+1];
        else if(result[i] == result[i+1])
            answer += mbti[i];
        else
            answer += mbti[i];

        i += 2;
    }

    return answer;
}
