# 덱
import sys
input = sys.stdin.readline

n = int(input())
deck = []
for _ in range(n):
  command = input().split()
  if command[0] == "push_front":
    deck.insert(0, command[1])
  elif command[0] == "push_back":
    deck.append(command[1])
  elif command[0] == "pop_front":
    if not deck:
      print(-1)
    else:
      print(deck.pop(0))
  elif command[0] == "pop_back":
    if not deck:
      print(-1)
    else:
      print(deck.pop())
  elif command[0] == "size":
    print(len(deck))
  elif command[0] == "front":
    if not deck:
      print(-1)
    else:
      print(deck[0])
  elif command[0] == "back":
    if not deck:
      print(-1)
    else:
      print(deck[-1])
  elif command[0] == "empty":
    if not deck:
      print(1)
    else:
      print(0)
