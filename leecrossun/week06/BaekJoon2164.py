# 카드2
import collections
n = int(input())

deque = collections.deque([])

for i in range(1,n+1):
    deque.append(i)

while 1:
    # 갯수 체크
    if len(deque) == 1:
        print(deque[0])
        break
    
    # 제일 위에 있는 카드를 버린다
    deque.popleft()
    if len(deque) == 1:
        print(deque[0])
        break

    # 갯수 체크
    if len(deque) == 1:
        print(deque[0])
        break

    # 그 다음, 제일 위에 있는 카드를 제일 아래로 옮긴다
    deque.append(deque.popleft())
    if len(deque) == 1:
        print(deque[0])
        break
