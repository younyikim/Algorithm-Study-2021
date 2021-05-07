# 벽 부수고 이동하기
from collections import deque

row, col = map(int, input().split())
graph = [list(map(int, input())) for _ in range(row)]
visited = [[[0] * 2 for _ in range(col)] for _ in range(row)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def Bfs(start_x, start_y, iscrash, visited, graph):
    #crash 0: 벽안부시고 가는경우, 1: 부신 경우
    queue = deque()
    queue.append((start_x, start_y, iscrash))
    visited[start_x][start_y][iscrash] = 1

    while queue:
        cur_x, cur_y, iscrash = queue.popleft()
        if cur_x == row - 1 and cur_y == col - 1:
            return visited[cur_x][cur_y][iscrash]
        for i in range(4):
            new_x = cur_x + dx[i]
            new_y = cur_y + dy[i]

            if new_x <= -1 or new_x >= row or new_y <= -1 or new_y >= col:
                continue
            # 벽 안부수고 이동
            if graph[new_x][new_y] == 0 and visited[new_x][new_y][iscrash] == 0:
                queue.append((new_x, new_y, iscrash))
                visited[new_x][new_y][iscrash] = visited[cur_x][cur_y][iscrash] + 1
            # 벽 부수고 이동
            if graph[new_x][new_y] == 1 and iscrash == 0:
                queue.append((new_x, new_y, iscrash + 1))
                visited[new_x][new_y][iscrash + 1] = visited[cur_x][cur_y][iscrash] + 1

    return -1

print(Bfs(0, 0, 0, visited, graph))