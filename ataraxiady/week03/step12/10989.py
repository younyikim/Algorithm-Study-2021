import sys

n = int(sys.stdin.readline())
# 조건 내 가장 큰 counting array를 생성한다
counting_array = [0 for _ in range(10001)]

for i in range(n):
    num = int(sys.stdin.readline())
    counting_array[num] += 1


# counting array의 값 만큼 인덱스를 출력한다.
for j in range(1,10001):
    count = counting_array[j]
    for _ in range(count):
        print(j)