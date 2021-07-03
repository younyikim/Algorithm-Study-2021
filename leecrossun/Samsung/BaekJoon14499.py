# 주사위 굴리기
N, M, x, y, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
com = list(map(int, input().split())) # 1234 동서남북
