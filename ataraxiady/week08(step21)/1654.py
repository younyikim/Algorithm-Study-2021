import sys

K, N = map(int, input().split())
lan = [int(sys.stdin.readline()) for _ in range(K)]
start, end = 1, max(lan)

while start <= end:
    mid = (start + end) // 2
    lines = 0
    # 모든 랜선 값을 mid로 나누어 총 몇개의 랜선이 나오나 확인
    for i in lan:
        lines += i // mid

    # 랜선이 목표치 이상일 때
    if lines >= N:
        start = mid + 1
    # 목표치 이하일 때
    else:
        end = mid - 1
print(end)