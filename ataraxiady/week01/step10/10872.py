n = int(input())

def fac(n):
    if n > 0:
        n = n * fac(n-1)
    if n == 0:
        n = 1
    return n

print(fac(n))