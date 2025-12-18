class Solution {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b)->a[0]-b[0]);
        int[] group = new int[n]; 
        int[] size = new int[n];
        for(int i=0;i<n;i++){
            group[i] = i;
            size[i] = 1;
        }
        int groupCnt = n;
        for(int[] log: logs){
            int firstGroup = find(group, log[1]);
            int secondGroup = find(group, log[2]);
            if(firstGroup!=secondGroup){
                union(group, size, log[1], log[2]);
                if(--groupCnt==1)
                    return log[0];
            }
        }
        return -1;

    }

    public int find(int[] group, int person){
        if(group[person] != person)
            group[person] = find(group, group[person]);
        return group[person];
    }

    public void union(int[] group, int[] size, int firstPerson, int secondPerson){
        if(size[firstPerson] < size[secondPerson]) union(group, size, secondPerson, firstPerson);

        int firstRoot = find(group, firstPerson);
        int secondRoot = find(group, secondPerson);
        group[secondRoot] = firstRoot;
        size[firstRoot]+=size[secondRoot];
        // 0 1 2 3
        // 1 1 1 1
    }


}