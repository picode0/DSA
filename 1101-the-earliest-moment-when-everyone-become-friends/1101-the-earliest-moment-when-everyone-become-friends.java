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

            if(union(group,size,log[1],log[2]) && --groupCnt==1){
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

    public boolean union(int[] group, int[] size, int firstPerson, int secondPerson){

        int firstGroup = find(group, firstPerson);
        int secondGroup = find(group, secondPerson);

        if(size[firstGroup] < size[secondGroup]) return union(group, size, secondPerson, firstPerson);

        if(firstGroup==secondGroup)
            return false;


        group[secondGroup] = firstGroup;
        size[firstGroup]+=size[secondGroup];
        return true;

    }


}