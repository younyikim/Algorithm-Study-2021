import sys

n = int(sys.stdin.readline())
coordinates = []

for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    coordinates.append([x, y])

# key부분에서 xy[1]은 y, xy[0]은 x를 의미한다.
# xy[1] 즉 y를 기준으로 오름차순 정렬하고 y가 같다면 그 다음 순위로는 xy[0]인 x로 오름차순 정렬한다는 코드이다.
# 만약 y로 오름차순 정렬하고 그 다음 순위로 x를 내림차순 정렬을 하고싶다면 key=lambda xy:(xy[1],-xy[0]) 이렇게 마이너스를 앞에 붙여주면 된다!
coordinates.sort(key=lambda xy:(xy[1],xy[0]))

for xy in coordinates:
    print(xy[0],xy[1])