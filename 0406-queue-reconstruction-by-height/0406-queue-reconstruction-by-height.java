class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);

        List<int[]> ret = new ArrayList<>();

        for(int[] person: people){
            ret.add(person[1], person);
        }

        return ret.toArray(new int[people.length][2]);

    }
}