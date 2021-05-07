import sys

n = int(sys.stdin.readline())
A = list(map(int,sys.stdin.readline().split()))
A.sort()
m = int(sys.stdin.readline())
m_list = list(map(int,sys.stdin.readline().split()))


def binary(A, num, low, high):
    if low > high:
        return False
    mid = (low + high) // 2
    if A[mid] > num:
        return binary(A, num, low, mid-1)
    elif A[mid] < num:
        return binary(A, num, mid+1, high)
    else:
        return True


for num in m_list:
    if binary(A,num,0,n-1):
        print(1)
    else:
        print(0)