class FoodRatings {
    Map<String, Pair<String,Integer>> foodMap;
    Map<String, PriorityQueue<Pair<String,Integer>>> cusineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>(); 
        cusineMap = new HashMap<>();

        int n = foods.length;
        for(int i=0;i<n;i++){
            foodMap.put(foods[i], new Pair<>(cuisines[i], ratings[i]));
            cusineMap.putIfAbsent(cuisines[i], 
            new PriorityQueue<>((a,b)-> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue()));
            cusineMap.get(cuisines[i]).offer(new Pair<>(foods[i],ratings[i]));
        }

    }
    
    public void changeRating(String food, int newRating) {
        String foodType = foodMap.get(food).getKey();
        foodMap.put(food, new Pair<>(foodType, newRating));
        cusineMap.get(foodType).offer(new Pair<>(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair<String,Integer>> pq = cusineMap.get(cuisine);

        while(!pq.isEmpty() && !pq.peek().getValue().equals(foodMap.get(pq.peek().getKey()).getValue())){
            pq.poll();
            /*
            if(p.getValue() == foodMap.get(p.getKey()).getValue()){
                return p.getKey();
            }
            */
        }
        return pq.peek().getKey();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */