# AC
import collections
import sys
input = sys.stdin.readline
t = int(input())

for _ in range(t):
    p = input()
    n = int(input())
    
    temp = input().lstrip('[').rstrip(']\n').split(',')
    arr = [temp[k] for k in range(n)]
    d = collections.deque(arr)
    
    error = -1
    delete_head = 0
    delete_tail = 0
    is_reverse = -1
    for cmd in p:
        if cmd == "R":
            is_reverse *= -1
        elif cmd == "D":
            if delete_head + delete_tail == n:
                print("error")
                error = 1
                break
            else:
                if is_reverse == -1:
                    delete_head += 1
                else:
                    delete_tail += 1
    

    if error == -1:
        print("[",end='')
        if is_reverse == -1:
            for i in range(delete_head, n - delete_tail):
                if d[i] != -1:
                    if i < n - delete_tail - 1:
                        print(d[i],end=',')
                    else:
                        print(d[i],end='')
        else:
            for i in range(n - delete_tail -1, delete_head - 1, -1):
                if d[i] != -1:
                    if i > delete_head:
                        print(d[i],end=',')
                    else:
                        print(d[i],end='')
        print("]")