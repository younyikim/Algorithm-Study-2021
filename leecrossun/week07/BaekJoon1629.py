# 곱셈
def calc(a, b):
    if b == 1:
        return a % c
    else:
        t = calc(a, b // 2)
        if b % 2 == 0:
            return t * t % c
        else:
            return t * t * a % c

a, b, c = map(int, input().split())

print(calc(a,b))
