n = int(input())
maps = [input() for _ in range(n)]
nums = 0


for i in range(n):
    temp = maps.pop(0)
    arr=[]
    for j in temp:
        arr.append(int(j))
    maps.append(arr)

for i in range(n):
    for j in range(n):
        if(maps[i][j]==1):
            maps[i][j]='-'

def dfs(r,c):
    global maps,nums,n
    nums+=1
    cnt =0

    visited = [[0]* n for _ in range(n)]
    stack = [(r,c)]
    visited[r][c]=1
    cnt+=1
    maps[r][c]=nums

    dr = [1,0,-1,0]
    dc = [0,1,0,-1]

    while(stack):
        cur_r,cur_c = stack.pop()
        for i in range(4):
            nr = cur_r + dr[i]
            nc = cur_c + dc[i]
            if(nr>=n or nr<0 or nc>=n or nc<0 ):
                continue
            if(visited[nr][nc]==0 and maps[nr][nc]=='-'):
                visited[nr][nc]=1
                stack.append((nr,nc))
                maps[nr][nc]=nums
                cnt+=1

    return cnt

res = []
for i in range(n):
    for j in range(n):
        if(maps[i][j]=='-'):
            res.append(dfs(i,j))

print(nums)
res.sort()
for i in res:
    print(i)