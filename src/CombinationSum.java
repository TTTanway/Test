import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates,target);
        System.out.println(result);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine  = new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }
    public void dfs(int[] candidates,int target,List<List<Integer>> ans,List<Integer> combine,int index){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
       //直接跳过index位置的元素
        dfs(candidates,target,ans,combine,index+1);
       // 选择当前数
        if(target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index],ans,combine,index);// 递归这里index不加1，因为可以重复选择当前数
            combine.remove(combine.size()-1);
        }
    }
}
