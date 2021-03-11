n = int(input())

def fibo(n):
    if n == 0:
        n = 0
    if n == 1:
        n = 1
    if n >= 2:
        n = fibo(n-1)+fibo(n-2)
    return n
print(fibo(n))