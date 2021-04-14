import sys

n = int(sys.stdin.readline())
s = list(map(int, sys.stdin.readline().split()))
op = list(map(int, sys.stdin.readline().split()))
max_result = -1000000001
min_result = 1000000001

def dfs(count,result,add,sub,mul,div):
    global max_result
    global min_result

    if count == n:
        max_result = max(max_result,result)
        min_result = min(max_result,result)
        return
    if add:
        dfs(count+1,result+s[count],add-1,sub,mul,div)
    if sub:
        dfs(count+1,result-s[count],add,sub-1,mul,div)
    if mul:
        dfs(count + 1, result * s[count], add, sub, mul - 1, div)
    if div:
        dfs(count+ 1, -(-result // s[count]) if result < 0 else result // s[count], add, sub, mul, div - 1)

dfs(1, s[0], op[0], op[1], op[2], op[3])
print(max_result)
print(min_result)