import heapq


v, e = map(int, input().split())
s = int(input())

# for _ in range(e):


def daikstra(start):
    heap = []

    # heap은 이진트리이기 때문에 삽입, 삭제하는데에 O(log n)
    heapq.heappush(heap, (4, start))
    heapq.heappush(heap, (2, start))
    heapq.heappush(heap, (3, start))
    heapq.heappush(heap, (0, start))

    print(heap)

daikstra(7)

