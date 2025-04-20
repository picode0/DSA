class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        System.out.println(split.length);
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);

        for(int i=1;i<split.length;i++){
            sb.insert(0, split[i]+" ");
           //System.out.println("what " + split[i]);
        }

        return sb.toString();

         
    }
}