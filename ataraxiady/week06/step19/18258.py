import sys
from collections import deque

n = int(sys.stdin.readline())
arr = deque([])


def push(n,arr):
    # 큐 맨 뒤에 새로운 요소를 추가한다.
    arr.append(n)

def pop(arr):
    if len(arr) == 0:
        print(-1)
    else:
        print(arr.popleft())

def empty(arr):
    if len(arr) == 0:
        print(1)
    else:
        print(0)

def size(arr):
    print(len(arr))

def front(arr):
    if len(arr) == 0:
        print(-1)
    else:
        print(arr[0])

def back(arr):
    if len(arr) == 0:
        print(-1)
    else:
        print(arr[-1])

for _ in range(n):
    a = sys.stdin.readline()
    if 'push' in a:
        # 배열에 입력문의 숫자만 넣도록 문자열 조작을 한다
        b = a.rstrip('\n')
        b = b.split(' ')
        push(b[1],arr)
    if 'pop' in a:
        pop(arr)
    if 'size' in a:
        size(arr)
    if 'empty' in a:
        empty(arr)
    if 'front' in a:
        front(arr)
    if 'back' in a:
        back(arr)