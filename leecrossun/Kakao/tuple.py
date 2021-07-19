# 튜플
import re
def solution(s):
    answer = []
    s = s[1:-1].split(",{")
    s.sort(key = len)
    print(s)
    for i in s:
        numbers = re.findall("\d+",i)
        print(numbers)
        for j in numbers:
            if int(j) not in answer:
                answer.append(int(j))

    return answer