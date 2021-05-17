from collections import deque

def solution(s):
    answer = ""
    word = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    temp = ""
    ans = deque()
    for i in s:
        ascii = ord(i)
        if ascii >= 48 and ascii <= 57:
            ans.append(i)
        else:
            temp += i
            for j in range(10):
                if word[j] == temp:
                    ans.append(str(j))
                    temp = ""
    for n in ans:
        answer += n
    
    return int(answer)


s1 = "one4seveneight"
s2 = "23four5six7"
s3 = "2three45sixseven"
s4 = "123"
print(solution(s3))