class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        backtrack(candidates, target, 0, comb);
        return ret;
    }

    public void backtrack(int[] candidates, int target, int start, LinkedList<Integer> comb){
        if(target==0){
            ret.add(new ArrayList<>(comb));
            return;
        }

        if(target<0)
            return;

        for(int i=start;i<candidates.length;i++){
            comb.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, comb);
            comb.removeLast();
        }
        return;
    }
}