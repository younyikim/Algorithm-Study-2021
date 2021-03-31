import sys

n, k = map(int, sys.stdin.readline().split())
arr = []
for _ in range(n):
    arr.append(int(sys.stdin.readline()))
c = 0

for i in range(n-1,-1,-1):
    if k == 0:
        break
    if arr[i] > k:
        continue
    # 몫을 카운트하고
    c = c + k // arr[i]
    # 나머지를 k로 변경
    k = k % arr[i]

print(c)

# while문을 사용할 시 pyp3로는 성공하나 python3는 시간 초과가 뜬다.
# for i in range(n-1,-1,-1):
#     if k == 0:
#         break
#     if arr[i] > k:
#         continue
#     while True:
#         k = k - arr[i]
#         c = c + 1
#         if k < arr[i]:
#             break
#
# print(c)