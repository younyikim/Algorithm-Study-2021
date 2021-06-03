package level30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek_17472 {
    static int N, M;
    static int[][] map;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1)
                    map[i][j] = -1;
            }
        }

        // 맵 라밸링 맵의개수 파악 (섬에 번호를 붙여준다.) => DFS
        int island = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    DFS(i, j, island++);
                }
            }
        }

        // 간선의 비용 구하기
        // 각 섬에서 출발해 도착 가능한 섬에 건설할 수 있는 최소비용을 찾는다 => BFS
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 1; i < island; i++) {
            for (int j = i + 1; j < island; j++) {
                int cost = getBridge(i, j);
                if (cost != 0)
                    pq.add(new int[] { i, j, cost });
            }
        }

        // makeSet
        parent = new int[island];
        for (int i = 1; i < island; i++) {
            parent[i] = i;
        }

        int ans = 0;
        
        // 모든 섬을 연결하는 다리 길이의 최솟값을 찾는다 => MST
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = find(now[0]);
            int y = find(now[1]);
            if (x != y) {
                union(now[0], now[1]);
                ans += now[2];
            }
        }

        // 결과
        boolean flag = true;
        for (int i = 1; i < island; i++) {
            if (find(i) != 1) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? ans : -1);
    }

    private static void union(int i, int j) {
        int x = find(i);
        int y = find(j);

        if (x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    private static int find(int i) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i]);
    }

    private static int getBridge(int start, int end) {
        boolean[][][] visit = new boolean[N][M][4];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != start)
                    continue;
                for (int k = 0; k < dr.length; k++) {
                    int r = i + dr[k];
                    int c = j + dc[k];
                    if (!isRange(r, c) || map[r][c] != 0)
                        continue;
                    q.add(new int[] { r, c, 0, k });
                    visit[r][c][k] = true;
                }
            }
        }

        int ret = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (map[now[0]][now[1]] == end) {
                if (now[2] == 1)
                    continue;
                ret = now[2];
                break;
            }
            int nr = now[0] + dr[now[3]];
            int nc = now[1] + dc[now[3]];

            if (isRange(nr, nc) && !visit[nr][nc][now[3]]
                    && (map[nr][nc] == 0 || map[nr][nc] == end)) {
                visit[nr][nc][now[3]] = true;
                q.add(new int[] { nr, nc, now[2] + 1, now[3] });
            }
        }

        return ret;
    }

    private static void DFS(int i, int j, int cnt) {
        map[i][j] = cnt;
        for (int k = 0; k < dc.length; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (isRange(nr, nc) && map[nr][nc] == -1) {
                DFS(nr, nc, cnt);
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (0 <= nr && nr < N && 0 <= nc && nc < M)
            return true;
        return false;
    }
}
