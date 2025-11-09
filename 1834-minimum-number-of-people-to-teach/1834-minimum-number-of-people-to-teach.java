class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> toTeach = new HashSet<>();

        for(int[] friend: friendships){
            boolean know = false; 
            Set<Integer> lang = new HashSet<>();
            for(int language: languages[friend[0]-1]){
                lang.add(language);
            }
            for(int language: languages[friend[1]-1]){
                if(lang.contains(language)){
                    know = true;
                    break;
                }
            }
            if(!know){
                toTeach.add(friend[0]-1);
                toTeach.add(friend[1]-1);
            }
        }

        int[] langCount = new int[n+1];
        int maxC  = 0;
        for(int friend: toTeach){
            for(int lang: languages[friend]){
                langCount[lang-1]++;
                maxC = Math.max(maxC, langCount[lang-1]);
            }
        }
        return toTeach.size()-maxC;
    }
}