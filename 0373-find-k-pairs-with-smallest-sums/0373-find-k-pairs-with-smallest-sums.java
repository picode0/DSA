class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ret = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->a[0]-b[0]);

        for(int num:nums1){
            pq.offer(new int[]{num+nums2[0],0});
        }

        for(int i=0;i<k;i++){
            int[] poll = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(poll[0]-nums2[poll[1]]);
            list.add(nums2[poll[1]]);
            ret.add(list);
            if(poll[1]+1 < nums2.length){
                pq.add(new int[]{poll[0]-nums2[poll[1]]+nums2[poll[1]+1],poll[1]+1});
            }
        }

        return ret;


    }
}