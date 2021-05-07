# 팰린드롬?
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
N = int(input()) # 수열의 크기
A = list(map(int, input().split())) # 자연수 배열
M = int(input())
dp = [[-1]*N for _ in range(N)]
def palindrome (s, e):
    print("s :", s, "e :", e)
    # 맨 앞과 맨 끝이 다를경우 팰린드롬 아님
    if A[s] != A[e]:
        return 0
    # 맨 앞과 맨 끝이 같을경우
    # 길이가 1이거나 2일 경우 무조건 true
    if s == e or s == e - 1:
        return 1
        
    if dp[s+1][e-1] == -1: # memoization 비었을 경우
        dp[s+1][e-1] = palindrome(s+1, e-1)
    
    return dp[s+1][e-1]

for _ in range(M):
    S, E = map(int, input().split())
    print(palindrome(S-1, E-1))
