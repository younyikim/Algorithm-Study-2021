MOD = 1000000007
def fibo(n):
    if result.get(n) != None:
        return result[n]
    else:
        if n % 2:
            f = (fibo((n+1) // 2) % MOD) ** 2 + (fibo(n // 2) % MOD) ** 2
        else:
            f1 = fibo(n // 2 - 1) % MOD
            f2 = fibo(n // 2) % MOD
            f = ((f1 + f2) * f2 + f2 * f1) % MOD
        
        result[n] = f % MOD
        return f % MOD


s = int(input())
result = {0: 0, 1: 1}
print(fibo(s))