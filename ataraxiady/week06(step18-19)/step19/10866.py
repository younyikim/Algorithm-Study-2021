import sys
from collections import deque

n = int(sys.stdin.readline())
arr = deque([])


def push_front(n,arr):
    arr.insert(0,n)

def push_back(n,arr):
    arr.append(n)

def pop_front(arr):
    if len(arr) == 0:
        print(-1)
    else:
        print(arr.popleft())

def pop_back(arr):
    if len(arr) == 0:
        print(-1)
    else:
        print(arr.pop())

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
    if 'push_front' in a:
        b = a.rstrip('\n')
        b = b.split(' ')
        push_front(b[1],arr)
    elif 'push_back' in a:
        b = a.rstrip('\n')
        b = b.split(' ')
        push_back(b[1],arr)
    elif 'pop_front' in a:
        pop_front(arr)
    elif 'pop_back' in a:
        pop_back(arr)
    elif 'size' in a:
        size(arr)
    elif 'empty' in a:
        empty(arr)
    elif 'front' in a:
        front(arr)
    elif 'back' in a:
        back(arr)