class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        //  5 9 3 1 8   2
        int[] sortednums = new int[nums.length]; 
        for(int i=0;i<nums.length;i++)
            sortednums[i] = nums[i];
        Arrays.sort(sortednums);

        Map<Integer,Integer> numtoG = new HashMap<>();

        Map<Integer, Queue<Integer>> group = new HashMap<>();
        int groupidx = 0; 

        numtoG.put(sortednums[0], groupidx);
        Queue<Integer> list = new LinkedList<>();
        list.add(sortednums[0]);
        group.put(groupidx, list);

        for(int i=1;i<sortednums.length;i++){
            if(Math.abs(sortednums[i] - sortednums[i-1]) > limit)
                groupidx++;
            
            
            Queue<Integer> grouplist = group.getOrDefault(groupidx, new LinkedList<>());
            grouplist.add(sortednums[i]);
            group.put(groupidx, grouplist);
            
            //group.getOrDefault(groupidx, new LinkedList<>()).add(nums[i]);
            numtoG.put(sortednums[i], groupidx);
        }

        for(int i =0;i<nums.length;i++){
            int groupnum = numtoG.get(nums[i]);
            //System.out.println(groupnum + " " + newnum);
            nums[i] = group.get(groupnum).poll();
        }

        return nums;

    // 1 7 6 18 2 1 -> 1 1 2 6 7 18


        
    }
}