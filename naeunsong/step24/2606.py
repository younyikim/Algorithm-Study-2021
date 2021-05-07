
def dfs(arr, n, m):

    for i in range(m):
        if arr[i][0] == n and ch[arr[i][1]]  == 0:
            ch[arr[i][1]] = 1
            dfs(arr, arr[i][1], m)
        if arr[i][1] == n and ch[arr[i][0]]  == 0:
            ch[arr[i][0]] = 1
            dfs(arr, arr[i][0], m)


n = int(input())
m = int(input())

ch = [0 for _ in range(101)]
li = []
for _ in range(m):
    li.append(list(map(int, input().split())))

ch[1] = 1
dfs(li, 1, m)

print(ch.count(1)-1)
