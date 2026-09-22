class Solution {
    public int totalFruit(int[] fruits) {
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currentMax = 0;
        int max = 0;

        for (int fruit : fruits) {
            if (fruit == lastFruit || fruit == secondLastFruit) {
                // If the fruit is already in our 2-basket set, expand the window
                currentMax++;
            } else {
                // New fruit type: window resets to consecutive lastFruits + current fruit
                currentMax = lastFruitCount + 1;
            }

            // Update consecutive count for lastFruit
            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currentMax);
        }

        return max;
    }
}
