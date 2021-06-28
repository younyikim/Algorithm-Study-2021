# 비밀지도
def solution(n, arr1, arr2):
    answer = []

    for i in range(n):
        x = bin(arr1[i])[2:].zfill(n)
        y = bin(arr2[i])[2:].zfill(n)

        temp = ""
        for j in range(n):
            if x[j] == '1' or y[j] == '1':
                temp += '#'
            else:
                temp += ' '
        
        answer.append(temp)

    return answer


n = int(input())
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))

print(solution(n, arr1, arr2))