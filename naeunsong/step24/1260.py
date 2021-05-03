from collections import deque

def dfs(arr, N, num):
    print(num, end=' ')
    ch[num] = 1

    for i in range(1,N+1):
        if arr[num][i] == 1 and ch[i] == 0:
            dfs(arr, N, i)

def bfsA(arr, N, q):

    while len(q) != 0:
        s_n = q.pop()
        print(s_n, end=' ')

        for i in range(1,N+1):
            if arr[s_n][i] == 1 and ch[i] == 0:
                ch[i] = 1
                q.append(i)


n, m, v = map(int, input().split())

ch = [0 for _ in range(1001)]
s = [[0 for _ in range(1001)] for _ in range(1001)]

for i in range(m):
    a, b = map(int, input().split())
    s[a][b] = 1
    s[b][a] = 1

# dfs
ch[v] = 1
dfs(s, n, v)
print()

# bfs
ch = [0 for _ in range(1001)]
ch[v] = 1
Q = deque()
Q.append(v)
bfsA(s, n, Q)