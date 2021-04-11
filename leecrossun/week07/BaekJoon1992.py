# 쿼드트리

# 변수 선언
n = int(input())
arr = []
for _ in range(n):
    arr.append(input())

output = str()  # 출력결과

# 전체 사각형 검증
def inspect_square (arr, dir):
    global output
    s = arr[0][0]
    for i in arr:
        for j in i:
            if j != s:
                return -1 # 다른 원소 존재

    output += str(s)
    return s # 모든 원소가 같음 -> 원소 출력

# 메인함수
def calc (arr, n, dir):
    global output
    result = inspect_square(arr, dir)

    if result == -1: # 검증실패
        # 상자 4등분
        arr1 = list()
        arr2 = list()
        arr3 = list()
        arr4 = list()

        output += "("

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

        calc(arr1, n//2, 1)
        calc(arr2, n//2, 2)
        calc(arr3, n//2, 3)
        calc(arr4, n//2, 4)

        output += ")"

    return result

# main
calc(arr, n, 0)
print(output)



