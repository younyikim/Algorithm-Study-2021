def maxEvents(arrival, duration):
    result = list()
    cnt = 0
    size = arrival_count
    start = min(arrival)

    while 1:
        d_list = list()
        a_list = list()

        for i in range(size):
            if arrival[i] >= start:
                a_list.append(arrival[i])
                d_list.append(duration[i])

        minimum = 100000
        length = len(a_list)
        for i in range(length):
            minimum = min(a_list[i] + d_list[i], minimum)

        start = minimum
        result.append(start)
        if a_list == []:
            return cnt
        else:
            cnt += 1
    return cnt


arrival_count = int(input().strip())

arrival = []

for _ in range(arrival_count):
    arrival_item = int(input().strip())
    arrival.append(arrival_item)

duration_count = int(input().strip())

duration = []

for _ in range(duration_count):
    duration_item = int(input().strip())
    duration.append(duration_item)

print(maxEvents(arrival, duration))