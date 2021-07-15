def decode(codes, encoded):
    huff = {}
    
    for c in codes:
        temp = c.split('\t')
        huff[temp[1]] = temp[0]
    print(huff)
    res = ""
    size = len(encoded)
    
    i = 0
    while i < size-5:
        j = 1
        while 1:
            try:
                s = huff[encoded[i:i+j]]
                i += j
                break
            except:
                j += 1
                continue

        if s == "[newline]":
            res += '\n'
        else:
            res += s
    return res

codes_count = int(input().strip())
codes = []

for _ in range(codes_count):
    codes_item = input()
    codes.append(codes_item)

encoded = input()
print(decode(codes, encoded))