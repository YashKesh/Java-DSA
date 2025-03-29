package Graph;
import java.util.*;
/*
 * Given a start word, target word, and a list of words, find the length of the shortest transformation sequence from start to target.
 * Each transformed word must exist in the word list, and only one letter can be changed at a time.
 * The transformation sequence must begin with the start word and end with the target word.
 * If no such transformation sequence exists, return 0.
 */
public class WordLadder1 {

        public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
            // Queue for BFS where pair contains the current word and its transformation steps
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(startWord, 1));

            // Set to hold all words from wordList for quick access
            Set<String> wordSet = new HashSet<>(wordList);
            wordSet.remove(startWord); // Remove startWord from the set

            // Perform BFS
            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                String word = current.word;
                int steps = current.steps;

                // If the target word is found, return the steps
                if (word.equals(targetWord)) {
                    return steps;
                }

                // Explore all possible transformations
                for (int i = 0; i < word.length(); i++) {
                    char[] wordArray = word.toCharArray();
                    char originalChar = wordArray[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordArray[i] = ch;
                        String transformedWord = new String(wordArray);

                        // If the transformed word exists in the set, add it to the queue
                        if (wordSet.contains(transformedWord)) {
                            queue.add(new Pair(transformedWord, steps + 1));
                            wordSet.remove(transformedWord); // Remove the word from the set to prevent revisiting
                        }
                    }

                    wordArray[i] = originalChar; // Revert the change for the next iteration
                }
            }

            // Return 0 if no transformation sequence was found
            return 0;
        }

        // Helper class to hold a word and the number of steps taken to reach it
        static class Pair {
            String word;
            int steps;

            Pair(String word, int steps) {
                this.word = word;
                this.steps = steps;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();

            while (tc-- > 0) {
                int n = sc.nextInt();
                List<String> wordList = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    wordList.add(sc.next());
                }

                String startWord = sc.next();
                String targetWord = sc.next();

                WordLadder1 obj = new WordLadder1();
                int ans = obj.wordLadderLength(startWord, targetWord, wordList);
                System.out.println(ans);
            }

            sc.close();
        }
    }


