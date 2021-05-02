import sys
input = sys.stdin.readline

def solution(array):
    answer = list()
    max_num = max(array)

    copy = list(array)
    copy.sort()

    l = len(array)

    for i in range(l):
        if max_num == array[i]:
            answer.append(-1)
        temp = 0
        index = copy.index(array[i])
        min = copy[l-1]
        
        for j in range(index+1, l):
            #print("j", j)
            abs_num = abs(i - array.index(copy[j]))
            if min > abs_num:
                min = abs_num
                temp = array.index(copy[j])
       
        
        answer.append(temp)

    return answer

st = list(map(int, input().split()))
print(solution(st))