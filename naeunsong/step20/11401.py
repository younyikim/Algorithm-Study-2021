p = 1000000007
N, K = map(int, input().split())

def power(a, b):
    global p
    if b == 0:
        return 1
    else:
        if b % 2:
            return (power(a,b//2) ** 2 * a) % p
        else:
            return (power(a, b//2) ** 2) % p


# nCk를 나타내기 위해 팩토리얼을 dp로 구해줍니다.
fact = [1 for _ in range(N + 1)]

for i in range(2, N + 1):
    fact[i] = fact[i - 1] * i % p

# A는 nCk의 분자가되고 B는 분모가 됩니다.
A = fact[N]
B = (fact[N - K] * fact[K]) % p

#여기서 페르마의 소정리가 사용됨
print((A % p) * (power(B, p - 2) % p) % p)
