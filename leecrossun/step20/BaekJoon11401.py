# 이항 계수
def power(a, b):
    if b == 0:
        return 1
    if b % 2:
        return (power(a, b//2) ** 2 * a) % p
    else:
        return (power(a, b//2) ** 2) % p

n, k = map(int, input().split())
p = 1000000007

f = [1 for _ in range(n+1)]

for i in range(2, n+1):
    f[i] = f[i-1] * i % p

a = f[n]
b = (f[n-k] * f[k]) % p

print((a % p) * (power(b, p-2) % p) %p)