class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numGroup = isConnected.length;
        UF uf = new UF(numGroup);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1 && uf.union(i+1,j+1))
                    numGroup--;
            }
        }
        return numGroup;
    }

    class UF{
        int[] size;
        int[] head;

        public UF(int numGroup){
            size = new int[numGroup+1];
            head = new int[numGroup+1];
            for(int i=1;i<head.length;i++){
                head[i] = i;
                size[i] = 1;
            }
        }

        public int find(int groupNum){
            if(head[groupNum] == groupNum)
                return head[groupNum];
            head[groupNum] = find(head[groupNum]);
            return head[groupNum];
        }

        public boolean union(int groupA, int groupB){
            int aHead = find(groupA);
            int bHead = find(groupB);

            if(aHead==bHead)
                return false;
            
            if(size[aHead]>size[bHead]){
                head[bHead] = aHead;
                size[aHead]+=size[bHead];
            }
            else{
                head[aHead] = bHead;
                size[bHead] +=size[aHead];
            }
            return true;
        }

    }
}