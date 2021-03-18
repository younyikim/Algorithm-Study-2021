import sys
from itertools import combinations

n = int(sys.stdin.readline())
s = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
members = [i for i in range(n)]
possible_team = []

# 조합으로 가능한 팀 생성해주기
for team in list(combinations(members, n // 2)):
    possible_team.append(team)

min_stat_gap = 10000  # 갭이 가장 작은 값을 찾기 위하여
for i in range(len(possible_team) // 2):
    # A 팀
    team = possible_team[i]
    stat_A = 0  # A팀 능력치
    for j in range(n // 2):
        member = team[j]  # 멤버
        for k in team:
            stat_A += s[member][k]  # 멤버와 함께할 경우의 능력치들

    # A를 제외한 나머지 팀
    team = possible_team[-i - 1]
    stat_B = 0
    for j in range(n // 2):
        member = team[j]
        for k in team:
            stat_B += s[member][k]

    min_stat_gap = min(min_stat_gap, abs(stat_A - stat_B))

print(min_stat_gap)