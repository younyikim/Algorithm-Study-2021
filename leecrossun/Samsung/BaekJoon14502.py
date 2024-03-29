# 연구소
import copy
import sys
 
input = sys.stdin.readline
 
N, M = map(int, input().strip().split())
NM = []
for i in range(N):
    L = list(map(int, input().strip().split()))
    NM.append(L)
 
dr = [-1,0,1,0]
dc = [0,1,0,-1]
max_value = 0 
virus_list = []
for i in range(N):
    for j in range(M):
        if NM[i][j] == 2:
            virus_list.append([i,j])
 
def select_wall(start,count):
    global max_value
    if count == 3 :
        sel_NM = copy.deepcopy(NM)
        for num in range(len(virus_list)):
            r, c = virus_list[num]
            spread_virus(r, c, sel_NM)
        safe_counts = sum(i.count(0) for i in sel_NM)
        max_value = max(max_value,safe_counts)
        return True
    else :
        for i in range(start, N*M):
            r = i // M
            c = i % M
            if NM[r][c] == 0 :
                NM[r][c] = 1
                select_wall(i,count+1)
                NM[r][c] = 0
 
 
def spread_virus(r,c,sel_NM):
    if sel_NM[r][c] == 2:
        for dir in range(4):
            n_r = r+dr[dir]
            n_c = c+dc[dir]
            if n_r >= 0 and n_c >=0 and n_r < N and n_c < M :
                if sel_NM[n_r][n_c] == 0 :
                    sel_NM[n_r][n_c] = 2
                    spread_virus(n_r,n_c,sel_NM)
 
select_wall(0,0)
print(max_value)