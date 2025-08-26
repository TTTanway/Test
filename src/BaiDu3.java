import java.util.*;

public class BaiDu3 {
    public static void main(String[] args) {
        //nextInt() 遇到空格或回车都会把前面读到的数字返回。
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] type = new int[n+1];
        for(int i=1;i<=n;i++){
            type[i] = scanner.nextInt();
        }
        for(int i=0;i<q;i++){
            int start = scanner.nextInt();
            System.out.println(bfs(start,graph,type,n));
        }
    }

    public static int bfs(int start,List<List<Integer>> graph,int[] type,int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        int count = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(type[cur] == 2) continue;
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}
