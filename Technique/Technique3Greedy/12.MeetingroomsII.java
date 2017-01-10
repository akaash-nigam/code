    public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0)
        return 0;
        
    // Sort the intervals by start time
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.start - b.start; }
    });
    
    // Use a min heap to track the minimum end time of merged intervals
    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.end - b.end; }
    });
    
    // start with the first meeting, put it to a meeting room
    heap.offer(intervals[0]);
    
    for (int i = 1; i < intervals.length; i++) {
        // get the meeting room that finishes earliest
        Interval interval = heap.poll();
        
        if (intervals[i].start >= interval.end) {
            // if the current meeting starts right after 
            // there's no need for a new room, merge the interval
            interval.end = intervals[i].end;
        } else {
            // otherwise, this meeting needs a new room
            heap.offer(intervals[i]);
        }
        
        // don't forget to put the meeting room back
        heap.offer(interval);
    }
    
    return heap.size();
}



public int minMeetingRooms(Interval[] intervals) {
    if (intervals.length == 0) {
        return 0;
    }
    // sort
    Arrays.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    });
    // PriorityQueue
    PriorityQueue<Integer> ends = new PriorityQueue<Integer>();
    ends.offer(intervals[0].end);
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i].start >= ends.peek()) { // no overlap, then should update smallest end.
            ends.poll();
        } 
        ends.offer(intervals[i].end);
    }
    return ends.size();
}


   public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0)
        return 0;
        
    Comparator<Interval> comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };
    Arrays.sort(intervals, comp);
    
    PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.end - o2.end;
        }
    }
    );
    
    for (int i = 0; i < intervals.length; i++) {
        if (queue.isEmpty()) {
            queue.offer(intervals[i]); //start the first meeting in a new room.
        } else {
            Interval finishingMeeting = queue.poll(); // get the previous meeting with earliest finishing time.
            if (intervals[i].start < finishingMeeting.end) {
                queue.offer(intervals[i]); //the meeting isn't finished yet, start meeting in a new room.
            } else {
                finishingMeeting.end = intervals[i].end; // using the room by the previous meeting.
            }
            queue.offer(finishingMeeting);
        }

    }
    return queue.size();  
}


public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval o1, Interval o2){
               return o1.start - o2.start;
           } 
        });
        return helper(new ArrayList(Arrays.asList(intervals)));
    }
    
    private int helper(List<Interval> li){
        if(li.size() == 0)
            return 0;
        Interval pre = li.get(0);
        List<Interval> nextLi = new ArrayList();
        for(int i=1;i<li.size();i++){
            Interval inter = li.get(i);
            if(inter.start < pre.end){
                nextLi.add(inter);
            }else{
                pre = inter;
            }
        }
        return 1 + helper(nextLi);
    }
}