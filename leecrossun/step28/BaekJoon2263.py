# 트리의 순회
import sys
sys.setrecursionlimit(10**8)

n = int(input())
inorder = list(map(int,input().split(' ')))
postorder = list(map(int,input().split(' ')))
pos=[0]*(n+1)
for i in range(n):
    pos[inorder[i]] = i

def divide(in_start, in_end, post_start, post_end):
    if (in_start > in_end) or (post_start > post_end):
        return

    root = postorder[post_end]
    print(root, end=' ')

    divide(in_start, pos[root] - 1, post_start, post_start + pos[root] - in_start - 1)
    divide(pos[root] + 1, in_end, post_start + pos[root] - in_start, post_end - 1)

divide(0, n - 1, 0, n - 1)