import java.util.*;

public class HuaWei1 {
    // 内部类表示星系联盟
    static class Alliance {
        int totalStrength;    // 联盟总实力
        int maxLevel;         // 联盟中最高的文明等级
        String maxLevelGalaxy;// 文明等级最高的星系名称
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 消耗换行符
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            map.put(parts[0],Integer.parseInt(parts[1]));
        }
        int m = sc.nextInt();
        if (m > 0) {
            sc.nextLine(); // 消耗换行符
        }
        Map<String,List<String>> graph = new HashMap<>();
        for(String name:map.keySet()){
            graph.put(name,new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String[] parts = sc.nextLine().split(" ");
            graph.get(parts[0]).add(parts[1]);
            graph.get(parts[1]).add(parts[0]);
        }
        Set<String> visited = new HashSet<>();
        List<Alliance> alliances = new ArrayList<>();
        for(String galaxy:map.keySet()){
            if(!visited.contains(galaxy)){
                Queue<String> queue = new LinkedList<>();
                queue.offer(galaxy);
                visited.add(galaxy);
                Alliance alliance = new Alliance();
                while(!queue.isEmpty()){
                    String current = queue.poll();
                    int level = map.get(current);
                    alliance.totalStrength += level;
                    if(level > alliance.maxLevel){
                        alliance.maxLevel = level;
                        alliance.maxLevelGalaxy = current;
                    }

                    for(String neighbor:graph.get(current)){
                        if(!visited.contains(neighbor)){
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
                alliances.add(alliance);
            }
        }
        int maxTotalStrength = 0;
        String maxLevelGalaxy = "";
        for(Alliance alliance:alliances){
            if(alliance.totalStrength > maxTotalStrength) {
                maxTotalStrength = alliance.totalStrength;
                maxLevelGalaxy = alliance.maxLevelGalaxy;
            }
        }
        System.out.println(maxTotalStrength + " " + maxLevelGalaxy);
        sc.close();
    }
}
