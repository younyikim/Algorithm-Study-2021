import sys

N, C = map(int, input().split())
house = [int(sys.stdin.readline()) for _ in range(N)]

# 정렬
house.sort()

# 간격을 얼마나 해야할지 모르니 간격의 최대거리와 최소거리의 중간부터 시작
left = 1
right = house[-1] - house[0]
answer = 0
while right >= left:
    # 간격의 중간값
    mid = (right + left) // 2

    # 첫 집에 공유기 설치
    wifi_cnt = 1
    before_install = house[0]
    for i in range(1, N):
        if house[i] >= before_install + mid:  # 설치 간격 충족
            wifi_cnt += 1
            before_install = house[i]

    # 공유기 개수가 C보다 작으면 더 설치해야 한다. 간격을 좁히자.
    if wifi_cnt < C:
        right = mid - 1
    # 공유기 개수가 C보다 많거나 같으면 덜 설치해야 한다. 간격을 넓히자.
    else:
        left = mid + 1
        # 중간에 mid를 저장하는 이유는 개수를 만족할 때 간격을 늘리려다가
        # 다음에는 개수를 만족시키지 못하고 while문이 종료될 수 있다.
        answer = mid

print(answer)