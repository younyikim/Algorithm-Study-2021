import sys, collections
input = sys.stdin.readline

def solution(inputString):
    answer = 0
    st = inputString
    l = len(st)
    q = collections.deque()
    cnt = 0

    for i in range(l):
        #print("t :", st[i], "an :", answer)
        # 괄호넣기
        if st[i] == '(' :
            q.append('(')
            cnt += 1
        elif st[i] == '{':
            q.append('{')
            cnt += 1
        elif st[i] == '[':
            q.append('[')
            cnt += 1
        elif st[i] == '<':
            q.append('<')
            cnt += 1

        # 짝검사
        if st[i] == ')':
            if len(q) == 0:
                answer = (-1) * i
                break
            p = q.pop()
            if '(' != p:
                answer = (-1) * i
                break
        elif st[i] == '}':
            if len(q) == 0:
                answer = (-1) * i
                break
            p = q.pop()
            if '{' != p:
                answer = (-1) * i
                break
        elif st[i] == ']':
            if len(q) == 0:
                answer = (-1) * i
                break
            p = q.pop()
            if '[' != p:
                answer = (-1) * i
                break
        elif st[i] == '>':
            if len(q) == 0:
                answer = (-1) * i
                break
            p = q.pop()
            if '<'!= p:
                answer = (-1) * i
                break
        
       
    first = st[0]
    if cnt == 0 or first == ')' or first == ']' or first == '>' or first == '}' :
        return 0

    if len(q) > 0 and answer == 0:
        answer = -1 * i

    if answer == 0:
        answer = cnt
    
    
        
    return answer

s = input()
print(solution(s))