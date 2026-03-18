class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1)
            return -1;

        UF uf = new UF(n);

        int size = n;

        for(int[] connection: connections){
            if(uf.union(connection[0], connection[1]))
                size--;
        }

        return size-1;
        
        
    }

    class UF{
        int[] group;

        UF(int groupSize){
            group = new int[groupSize];
            for(int i=0;i<group.length;i++)
                group[i] = i;
        }

        int find(int idx){
            if(group[idx] != idx)
                group[idx] = find(group[idx]);
            return group[idx];
        }

        boolean union(int n1, int n2){
            int n1lead = find(n1);
            int n2lead = find(n2);

            if(n1lead==n2lead)
                return false;
            else{
                group[n1lead] = n2lead;
                return true;
            }
        }
    }

}