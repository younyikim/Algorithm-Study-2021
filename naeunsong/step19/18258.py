from collections import deque
import sys

def isEmpty():
    if len(queue) == 0:
        return 1
    else:
        return 0

a = int(sys.stdin.readline())

queue = deque([])

for i in range(a):
    word = sys.stdin.readline().split()

    if word[0] == 'push':
        queue.append(word[1])
    elif word[0] == 'pop':
        if isEmpty():
            print(-1)
        else:
            print(queue.popleft())
    elif word[0] == 'front':
        if isEmpty():
            print(-1)
        else:
            print(queue[0])
    elif word[0] == 'back':
        if isEmpty():
            print(-1)
        else:
            print(queue[len(queue)-1])
    elif word[0] == 'size':
        print(len(queue))
    elif word[0] == 'empty':
        print(isEmpty())
