import java.util.Scanner;

public class OPPO_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] count = new int[m];
        for(int num:a){
            int r = num % m;
            count[r]++;
        }
        int target = n/m;  // 每个余数的目标数量
        int ans = 0;
        for(int i=0;i<n;i++){    //贪心算法，先把余数小的放好，再放余数大的
            int curMod = a[i] % m;
            if(count[curMod] > target){  //大于目标量，则对这个a[i]进行调整，使其余数变化
                for(int j=0;j<m;j++){
                    if(count[j]<target){//找到一个余数小于目标量的数，进行调整，使a[i]的余数变为j
                        int diff = (j-curMod+m)%m;
                        ans += diff;
                        count[curMod]--;
                        count[j]++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
