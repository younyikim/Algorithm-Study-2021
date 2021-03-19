import sys
n = int(sys.stdin.readline())
count = 0
# 하나의 배열에서 매번 상하좌우 대각선을 확인하는 것은 효율적이지않다.
# 고로 세로줄|, 대각선 줄 /, 대각선 줄\ 배열을 만들어 체크한다
a, b, c = [0 for _ in range(n)], [0 for _ in range(2 * n - 1)], [0 for _ in range(2 * n - 1)]

def queen_location(index):
    global count
    if index == n:    #행의 끝까지 퀸을 넣으면
        count += 1
        return
    for col in range(n):  #열을 이동하며
        if a[col] + b[index + col] + c[n - 1 + index - col] == 0: # 세 조건에 걸리지 않는다면
            a[col] = b[index + col] = c[n - 1 + index - col] = 1
            queen_location(index+1)
            a[col] = b[index + col] = c[n - 1 + index - col] = 0 # 초기화

queen_location(0)
print(count)
