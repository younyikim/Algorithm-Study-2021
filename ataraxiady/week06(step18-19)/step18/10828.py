import sys

n = int(sys.stdin.readline())
arr = []

def push(n,arr):
    # 스택의 가장 위에 쌓는다.
    arr.insert(0,n)

def pop(arr):
    if len(arr) == 0:
        print(-1)

    # 스택의 가장 위의 값을 출력하고 배열에서 없앤다.
    else:
        print(arr[0])
        arr.remove(arr[0])

def empty(arr):
    if len(arr) == 0:
        print(1)
    else:
        print(0)

def size(arr):
    print(len(arr))

def top(arr):
    if len(arr) == 0:
        print(-1)
    # 스택의 가장 상단 값, 즉 배열에서 가장 앞에 있는 값을 출력한다.
    else:
        print(arr[0])

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
    if 'top' in a:
        top(arr)



