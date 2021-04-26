# 수 찾기
N = int(input())
n = list(map(int, input().split()))

M = int(input())
m = list(map(int, input().split()))

n.sort()

def is_exist(key, start, end):
  if start > end:
    print("0")
    return
  index = (start + end)//2
  standard = n[index]
  if standard == key:
    print("1")
    return
  elif standard > key:
    is_exist(key, start, index-1)
  else:
    is_exist(key, index+1, end)

for item in m:
  is_exist(item, 0, N-1)