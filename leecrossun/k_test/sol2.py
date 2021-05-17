
from itertools import combinations

mv_row = [-1, 0, 1, 0]
mv_col = [0, 1, 0, -1]

def dfs(r, c, place, flag, s_i, s_j):
    #print("r, c : ",r,c)
    #print("flag : ", flag)
    s = list(place[r])
    if s[c] == "P" and r != s_i and c != s_j:
        calc = abs(s_i - r) + abs(s_j - c)
        print("calc", s_i, s_j, r, c, calc)
        if calc <= 2:
            flag = 0
            print("error",r,c, s_i, s_j)

    s[c] = "C" # 방문 체크
    place[r] = ''.join(s)
    for i in range(4):
        row = r + mv_row[i]
        col = c + mv_col[i]
        
        if row >= 0 and col >= 0 and row < 5 and col < 5:
            temp_s = list(place[row])
            if temp_s[col] == "P" or temp_s[col] == "O":
                flag = dfs(row, col, place, flag, s_i, s_j)
    return flag
                

def solution(places):
    answer = []
    for p in places:
        flag = 1
        place = list(p)
        for i in range(5):
            for j in range(5):
                if place[i][j] == "P":
                    flag = dfs(i,j,place, 1, i, j)
        answer.append(flag)
        print("--------")
    return answer

pl = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
print(solution(pl))