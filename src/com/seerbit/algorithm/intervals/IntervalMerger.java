package com.seerbit.algorithm.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalMerger {
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new ArrayList<>();
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (Interval interval : intervals) {
            if (interval.start <= currentInterval.end) {
                // Overlapping intervals, update the end of the current interval
                currentInterval.end = Math.max(currentInterval.end, interval.end);
            } else {
                // Non-overlapping interval, add the current interval to the result
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }
}
