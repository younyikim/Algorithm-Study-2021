import sys

n = int(sys.stdin.readline())
arr = []

def push(n,arr):
    arr.insert(0,n)

def pop(arr):
    if len(arr) != 0:
        arr.remove(arr[0])

for _ in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        pop(arr)
    else:
        push(num,arr)


print(sum(arr))