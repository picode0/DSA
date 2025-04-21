class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ret = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->(a[0]+a[1]) - (b[0]+b[1]));

        for(int num:nums1){
            pq.offer(new int[]{num, nums2[0], 0});
        }

        for(int i=0;i<k;i++){
            int[] pair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(pair[0]);
            list.add(pair[1]);
            if(pair[2]+1 < nums2.length)
                pq.offer( new int[]{pair[0], nums2[pair[2]+1], pair[2]+1});
            ret.add(list);
        }


        return ret;


    }
}