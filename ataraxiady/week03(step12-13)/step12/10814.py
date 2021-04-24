import sys

n = int(sys.stdin.readline())
values = []
for _ in range(n):
    age, name = map(str, sys.stdin.readline().split())
    values.append([age, name])

# 아래 주석처리한 코드를 사용하면 결과는 제대로 나오나 백준 사이트에서는 틀렸다는 결과가 나온다.
# values.sort(key=lambda x:x[0])
values.sort(key=lambda x:int(x[0]))

for i in range(n):
    print(' '.join(values[i]))