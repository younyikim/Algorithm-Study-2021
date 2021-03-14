import sys

n = int(sys.stdin.readline())
words = []
# 중복 문자열을 거른다.
for _ in range(n):
    word = sys.stdin.readline().strip()
    if word not in words:
        words.append(word)

words.sort(key=lambda w:(len(w),w))
print('\n'.join(words))