package com.seerbit.algorithm;

import com.seerbit.algorithm.intervals.Interval;

import java.util.Arrays;
import java.util.List;

import static com.seerbit.algorithm.intervals.IntervalMerger.mergeIntervals;
import static com.seerbit.algorithm.xor.XorSubArray.findMaxXORSubarray;

public class AlgorithmSolutions {
    public static void main(String[] args) {
//        runMergeIntervals();
        runMaximumSubArray();
    }

    private static void runMergeIntervals(){
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        List<Interval> merged = mergeIntervals(intervals);

        for (Interval interval : merged) {
            System.out.println("(" + interval.start + ", " + interval.end + ")");
        }
    }

    private static void runMaximumSubArray(){
        int[] arr = {2,1,8,5};
        int result = findMaxXORSubarray(arr);
        System.out.println("Maximum XOR subarray: " + result);
    }
}
