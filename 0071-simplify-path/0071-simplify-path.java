class Solution {
    public String simplifyPath(String path) {
        String[] files = path.split("/");
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        //System.out.println(files);
        for(String file: files){
            if(file.equals(".") || file.equals("")){
                continue;
            }
            else if(file.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(file);
                System.out.println(file);
            }
        }
        if(st.isEmpty())
            return "/";

        while(!st.isEmpty()){
            sb.insert(0, "/" + st.pop());
        }

        return sb.toString();

    }
}