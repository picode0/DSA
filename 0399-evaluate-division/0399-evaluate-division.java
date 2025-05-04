class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String,Double>>> map = new HashMap<>();

        for(int i=0;i<values.length;i++){
            List<Pair<String,Double>> vallist = map.getOrDefault(equations.get(i).get(0), new ArrayList<>());
            vallist.add(new Pair<>(equations.get(i).get(1), values[i]));
            map.put(equations.get(i).get(0), vallist);

            vallist = map.getOrDefault(equations.get(i).get(1), new ArrayList<>());
            vallist.add(new Pair<>(equations.get(i).get(0), 1.0/values[i]));
            map.put(equations.get(i).get(1), vallist);
        }

        double[] ret = new double[queries.size()];

        for(int i=0;i<ret.length;i++){
            ret[i] = dfs(map, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1), 1.0);
        }
        return ret;
    }

    public double dfs(Map<String, List<Pair<String,Double>>> map, Set<String> visited, String start, String end, double val){
        if(!map.containsKey(start))
            return -1.0;

        if(start.equals(end))
            return val;
        
        visited.add(start);
        //System.out.println(start + " " + end);
        for(Pair<String,Double> pair: map.get(start)){
            if(!visited.contains(pair.getKey())){
                double retval = dfs(map, visited, pair.getKey(), end, val*pair.getValue());
                if(retval>=0)
                    return retval;
            }
        }

        return -1.0;


    }
}