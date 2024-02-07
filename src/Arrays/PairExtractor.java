package Arrays;

public class PairExtractor {
    public static void main(String[] args) {
        String input = "[[1,3], [2,6], [8,10], [15,18]]";

        // Step 1: Remove brackets and spaces
        String cleanedInput = input.replaceAll("[\\[\\] ]", "");

        // Step 2: Split the string to separate pairs and elements
        String[] parts = cleanedInput.split("],\\[|,");

        // Initialize an array to store the pairs
        int[][] pairs = new int[parts.length / 2][2];

        // Step 3: Extract and store each pair
        int pairIndex = 0;
        for (int i = 0; i < parts.length; i += 2) {
            // Step 4: Convert elements to integers
            int first = Integer.parseInt(parts[i]);
            int second = Integer.parseInt(parts[i + 1]);
            pairs[pairIndex][0] = first;
            pairs[pairIndex][1] = second;
            pairIndex++;
        }

        // Now, 'pairs' is an array containing the extracted pairs.
        // You can access each pair as pairs[i][0] and pairs[i][1].

        // Print the pairs to verify
        for (int i = 0; i < pairs.length; i++) {
            System.out.println("Pair " + i + ": [" + pairs[i][0] + ", " + pairs[i][1] + "]");
        }
    }
}
