import sys
n = int(sys.stdin.readline())

def count_fibo(n):
    #f(0)일 때 f(0) 한 번 호출, f(1)일 때 f(0) 호출 x
    zeros = [1, 0]
    # f(0)일 때 f(1) 호출 x, f(1)일 때 f(1) 한 번 호출
    ones = [0, 1]

    for i in range(2, n + 1):
        zeros.append((zeros[i - 1] + zeros[i - 2]))
        ones.append((ones[i - 1] + ones[i - 2]))
    return zeros, ones

# 문제에서 N은 40보다 작거나 같은 자연수이므로 40을 넣어 최대 배열을 계산
zeros, ones = count_fibo(40)

for _ in range(n):
    m = int(sys.stdin.readline())
    print(zeros[m], ones[m])






# n = int(sys.stdin.readline())
# arr = []
# zeros = []
# ones = []
# for _ in range(n):
#     arr.append(int(sys.stdin.readline()))
#     zeros.append(0)
#     ones.append(0)
#
# def fibo(n,i):
#     if n == 0:
#         zeros[i] = zeros[i] + 1
#         return 0
#     if n == 1:
#         ones[i] = ones[i] + 1
#         return 1
#     if n >= 2:
#         return fibo(n-1,i)+fibo(n-2,i)
#
# for i in range(len(arr)):
#     fibo(arr[i],i)
#
# for j in range(len(zeros)):
#     print(zeros[j],ones[j])