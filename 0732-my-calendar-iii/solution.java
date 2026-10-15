class MyCalendarThree {
    // TreeMap keeps the timestamps sorted automatically
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        // A new event starts: increment the value at this timestamp
        timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
        
        // The event ends: decrement the value at this timestamp
        timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1);
        
        int activeEvents = 0;
        int maxBookings = 0;
        
        // Traverse the timeline chronologically
        for (int count : timeline.values()) {
            activeEvents += count; // Add the +1s and -1s
            maxBookings = Math.max(maxBookings, activeEvents);
        }
        
        return maxBookings;
    }
}
