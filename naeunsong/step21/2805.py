n, m = map(int, input().split())

arr = list(map(int, input().split()))

# 1. 제일 큰 값에서 검색하고 2로 나눈다.
# 2. 또 2로 나눈다. m보다 크면 위로(값을 넣는다), m보다 작으면 아래로
# 3. lh와 hh의 차이가 1 이하로 나면 종료한다 .

answer = 0

lh = 0
hh = max(arr)

while lh <= hh:
    sum_num = 0
    mh = (lh + hh) // 2

    sum_num = sum([tree - mh if tree > mh else 0 for tree in arr])
    # for tree in arr:
    #     if tree > mh:
    #         sum_num += (tree - mh)

    if sum_num >= m:
        answer = mh
        lh = mh + 1
    else:
        hh = mh - 1

print(answer)