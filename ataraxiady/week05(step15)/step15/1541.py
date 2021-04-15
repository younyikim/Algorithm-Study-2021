import sys

a = sys.stdin.readline().split('-')
s = 0

for i in a[0].split('+'):
    s = s + int(i)

for i in a[1:]:
    for j in i.split('+'):
        s = s - int(j)
print(s)
