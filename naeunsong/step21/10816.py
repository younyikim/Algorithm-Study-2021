

def binary(A, num, left, right):
    if left > right:
        return 0

    mid = (left+right)//2

    if A[mid] == num:
        return A[left:right+1].count(num)
    elif A[mid] < num:
        return binary(A, num, mid+1, right)
    else:
        return binary(A, num, left, mid-1)

n = (int)(input())

arrayA = []
arrayA = list(map(int, input().split()))
arrayA.sort()

m = (int)(input())

arrayB = []
arrayB = list(map(int, input().split()))

for i in range(m):
    print(binary(arrayA, arrayB[i], 0, len(arrayA)-1), end=' ')