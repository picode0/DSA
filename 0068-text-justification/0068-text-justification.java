class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();

        List<String> currLine = new ArrayList<>();
        int currlength = 0;
        for(String st: words){
            int needed = currlength + st.length() + (currLine.size()==0?0:1);

            if(needed>maxWidth){
                justify(ret, currLine, maxWidth);
                currLine = new ArrayList<>();
                currLine.add(st);
                currlength = st.length();
            }
            else{
                currlength = needed; 
                currLine.add(st);
            }
        }
        StringBuilder sb = new StringBuilder();

        int count = maxWidth;
        for(int i=0;i<currLine.size()-1;i++){
            sb.append(currLine.get(i) + " ");
            count-=currLine.get(i).length() +1;
        }
        String lastword = currLine.get(currLine.size()-1);
        sb.append(lastword + " ".repeat(count-lastword.length()));

        ret.add(sb.toString());

        return ret;

    }

    public void justify(List<String> ret, List<String> currLine, int maxWidth){
        // 4 2 2
        int base = -1;
        for(String st: currLine){
            base += st.length()+1;
        }

        int spacesneeded = maxWidth - base;
        if(currLine.size() ==1){
            ret.add(String.join(" ", currLine) + " ".repeat(spacesneeded));
            return;
        }

        int spacePerWord = spacesneeded / (currLine.size()-1);
        int extra = spacesneeded % (currLine.size()-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<currLine.size();i++){
            if(i!=currLine.size()-1){
                sb.append(currLine.get(i) + " ".repeat(spacePerWord+1));
                if(extra>0){
                    sb.append(" ");
                    extra--;
                }
            }
            else    
                sb.append(currLine.get(i));
        }

        ret.add(sb.toString());

    }
}