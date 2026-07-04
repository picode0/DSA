class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(nums, ret, new ArrayList<>());
        return ret;
    }

    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> curr){
        if(curr.size() == nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(curr.contains(nums[i]))
                continue;

            curr.add(nums[i]);
            backtrack(nums, list, curr);
            curr.remove(curr.size()-1);
            
        }
        return;
    }
}