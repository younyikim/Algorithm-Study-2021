# 소수의 연속합
N = int(input())

s = e = sum = cnt = 0

# 에라토스테네스의 체
is_prime = [True] * (N+1)
is_prime[0] = is_prime[1] = False

prime = []

i = 2
m = int(N ** 0.5)
for i in range(2, m+1):
    if is_prime[i] == True:
        for j in range(i+i, N+1, i):
            is_prime[j] = False


for i in range(2, N+1):
    if is_prime[i] == True:
        prime.append(i)

length = len(prime)

while 1:
    if sum == N: # 조건을 만족했을경우
        cnt += 1
        sum -= prime[s] # 맨 앞 원소 제외해봄
        s += 1 # 앞 포인터 이동
    elif sum > N: # 조건보다 클 경우
        sum -= prime[s] # 맨 앞 원소 제외해봄
        s += 1 # 앞 포인터 이동
    elif e >= length:
        break
    else: # 조건보다 작으면
        sum += prime[e] # 맨 끝 원소 추가해봄
        e += 1 # 끝 포인터 이동

print(cnt)