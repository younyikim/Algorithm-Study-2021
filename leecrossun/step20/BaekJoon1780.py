# 종이의 개수

# 변수 선언
n = int(input())
arr = list()
for _ in range(n):
    arr.append(list(map(int, input().split())))
one = zero = minus = 0 # 카운트변수

# 전체 사각형 검증
def inspect_square (arr):
    global one
    global zero
    global minus

    s = arr[0][0]
    for i in arr:
        for j in i:
            if j != s:
                return -1 # 다른 원소 존재
    if s == 1:
        one += 1
    elif s == 0:
        zero += 1
    else:
        minus += 1
    return 1 # 모든 원소가 같음 

# 메인함수
def calc (arr, n):

    result = inspect_square(arr)

    if result == -1: # 검증실패
        # 상자 9등분
        arr1 = list()
        arr2 = list()
        arr3 = list()
        arr4 = list()
        arr5 = list()
        arr6 = list()
        arr7 = list()
        arr8 = list()
        arr9 = list()

        # row 마다 돌면서 슬라이싱
        # arr1
        for i in range(n//3):
            arr1.append(arr[i][0:n//3])
        # arr2
        for i in range(n//3):
            arr2.append(arr[i][n//3:n//3*2])
        # arr3
        for i in range(n//3):
            arr3.append(arr[i][n//3*2:n])
        # arr4
        for i in range(n//3, n//3*2):
            arr4.append(arr[i][0:n//3])
        # arr5
        for i in range(n//3, n//3*2):
            arr5.append(arr[i][n//3:n//3*2])
        # arr6
        for i in range(n//3, n//3*2):
            arr6.append(arr[i][n//3*2:n])
        # arr7
        for i in range(n//3*2, n):
            arr7.append(arr[i][0:n//3])
        # arr8
        for i in range(n//3*2, n):
            arr8.append(arr[i][n//3:n//3*2])
        # arr9
        for i in range(n//3*2, n):
            arr9.append(arr[i][n//3*2:n])

        calc(arr1, n//3)
        calc(arr2, n//3)
        calc(arr3, n//3)
        calc(arr4, n//3)
        calc(arr5, n//3)
        calc(arr6, n//3)
        calc(arr7, n//3)
        calc(arr8, n//3)
        calc(arr9, n//3)

    return result

# main
calc(arr, n)
print(minus)
print(zero)
print(one)
