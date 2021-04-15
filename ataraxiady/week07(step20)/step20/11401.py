import sys
div = 1000000007
n, k = map(int,sys.stdin.readline().split())


# 분할 정복을 이용한 a^b
def power(a,b):
    if b == 0:
        return 1
    if b % 2:
        return (power(a, b // 2) ** 2 * a) % div
    else:
        return (power(a, b // 2) ** 2) % div

# 팩토리얼 구하기
fact = [1 for _ in range(n+1)]
for i in range(2,n+1):
    fact[i] = fact[i-1] * i % div

# 분모
denominator = (fact[n-k] * fact[k]) % div
# 분자
numerator = fact[n]

# 페르마 소정리
print((numerator % div) * (power(denominator, div - 2) % div) % div)