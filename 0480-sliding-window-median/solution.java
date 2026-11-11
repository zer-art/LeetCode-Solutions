import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> lowH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highH = new PriorityQueue<>();

        // Maps numbers waiting to be deleted to their frequency
        HashMap<Integer, Integer> deadCount = new HashMap<>();

        double[] res = new double[nums.length - k + 1];

        // 1. Initialize first window of size k
        for (int i = 0; i < k; i++) {
            lowH.add(nums[i]);
        }

        for (int i = 0; i < k / 2; i++) {
            highH.add(lowH.poll());
        }

        
        for (int i = k; ; i++) {
            // Get median for current window
            if (k % 2 == 1) {
                res[i - k] = (double) lowH.peek();
            } else {
                res[i - k] = ((double) lowH.peek() + highH.peek()) / 2.0;
            }

            // All windows processed
            if (i == nums.length) {
                break;
            }

            int out = nums[i - k]; // outgoing element
            int in = nums[i];      // incoming element
            int balance = 0;       // tracks net change between valid elements in lowH vs highH

            // Step A: Mark outgoing element and record which heap it leaves
            deadCount.put(out, deadCount.getOrDefault(out, 0) + 1);
            if (out <= lowH.peek()) {
                balance--; // leaving lowH
            } else {
                balance++; // leaving highH
            }

            // Step B: Insert incoming element and record which heap it enters
            if (!lowH.isEmpty() && in <= lowH.peek()) {
                lowH.add(in);
                balance++; // entering lowH
            } else {
                highH.add(in);
                balance--; // entering highH
            }

            // Step C: Rebalance based on valid element differential
            if (balance < 0) {
                // lowH needs one more valid element
                lowH.add(highH.poll());
                balance++;
            }
            if (balance > 0) {
                // highH needs one more valid element
                highH.add(lowH.poll());
                balance--;
            }

            // Step D: Prune lazy-deleted elements sitting at the top of either heap
            prune(lowH, deadCount);
            prune(highH, deadCount);
        }

        return res;
    }

    private void prune(PriorityQueue<Integer> heap, HashMap<Integer, Integer> deadCount) {
        while (!heap.isEmpty() && deadCount.getOrDefault(heap.peek(), 0) > 0) {
            int val = heap.peek();
            deadCount.put(val, deadCount.get(val) - 1);
            heap.poll();
        }
    }
}
