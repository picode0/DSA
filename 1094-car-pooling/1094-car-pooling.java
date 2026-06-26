class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timeStamp = new TreeMap<>();

        for(int[] trip: trips){
            int timeAdded = trip[1];
            int timeDropped = trip[2];
            int numPassengers = trip[0];

            timeStamp.put(timeAdded, timeStamp.getOrDefault(timeAdded, 0)+numPassengers);
            timeStamp.put(timeDropped, timeStamp.getOrDefault(timeDropped, 0)-numPassengers);
        }
        int passChange = 0;
        for(int passengers: timeStamp.values()){
            passChange += passengers;
            if(passChange > capacity)
                return false;
        }
        return true;
    }
}