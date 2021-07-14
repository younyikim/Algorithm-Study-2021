def getMinDeletions(s):
    arr = list(s)
    temp = list()
    for a in arr:
        if a not in temp:
            temp.append(a)
    
    return len(arr) - len(temp)

s = input()
print(getMinDeletions(s))