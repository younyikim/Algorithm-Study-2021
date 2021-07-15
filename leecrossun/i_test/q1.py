def maxTickets(tickets):
    res = 0
    size = len(tickets)

    cnt = 1
    tickets.sort()

    for i in range(1, size):
        if tickets[i] - tickets[i-1] <= 1:
            cnt += 1
        else:
            res = max(res, cnt)
            cnt = 1

    return res

tickets_count = int(input().strip())
tickets = []
for _ in range(tickets_count):
    tickets_item = int(input().strip())
    tickets.append(tickets_item)

print(tickets)

print(maxTickets(tickets))