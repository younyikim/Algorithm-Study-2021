# 색종이 만들기

# 변수 선언
n = int(input())
arr = list()
for i in range(n):
    arr.append(list(map(int, input().split())))
one = zero = 0 # 사각형 카운트k

# 전체 사각형 검증
def inspect_square (arr):
    global one
    global zero

    s = arr[0][0]
    for i in arr:
        for j in i:
            if j != s:
                return -1 # 다른 원소 존재
    if s == 1:
        one += 1
    else:
        zero += 1
    return s # 모든 원소가 같음 -> 원소 출력

# 메인함수
def calc (arr, n):

    result = inspect_square(arr)

    if result == -1: # 검증실패
        # 상자 4등분
        arr1 = list()
        arr2 = list()
        arr3 = list()
        arr4 = list()

        # row 마다 돌면서 슬라이싱
        # arr1
        for i in range(n//2):
            arr1.append(arr[i][0:n//2])
        # arr2
        for i in range(n//2):
            arr2.append(arr[i][n//2:n])
        # arr3
        for i in range(n//2, n):
            arr3.append(arr[i][0:n//2])
        # arr4
        for i in range(n//2, n):
            arr4.append(arr[i][n//2:n])

        calc(arr1, n//2)
        calc(arr2, n//2)
        calc(arr3, n//2)
        calc(arr4, n//2)

    return result

# main
calc(arr, n)
print(zero)
print(one)




