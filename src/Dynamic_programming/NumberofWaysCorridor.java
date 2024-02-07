package Dynamic_programming;
import java.util.*;
public class NumberofWaysCorridor {
    public static void main(String[] args) {
        NumberofWaysCorridor sol = new NumberofWaysCorridor();
        System.out.println(sol.numberOfWays("SSPPSPS"));
        System.out.println(sol.numberOfWays2("SSPPSPS"));
    }
    public int numberOfWays2(String corridor) {

        char[] array = corridor.toCharArray();
        int chairs = 0;
        long result = 1;

        for (int i = 0; i < array.length; i++) {

            // seat encountered
            if (array[i] == 'S') {
                chairs++;

                // advance to the next seat ignoring plants along the way
                while (++i < array.length && array[i] != 'S');
                if (i < array.length && array[i] == 'S') {
                    chairs++;
                }


                // there is one guaranteed division between adjacent pairs of seats
                // each plant between them adds an extra 1 division
                int divisions = 1;
                while (++i < array.length && array[i] != 'S') {
                    divisions++;
                }

                // if any extra divisions are possible, multiply our result by the divisions
                if (divisions > 1 && i < array.length) {
                    result = (result * divisions) % 1000000007;
                }
                i--;
            }
        }

        // if there are no chairs or an odd number of chairs there are no possible divisions
        // otherwise return our calculated result
        return (chairs != 0 && chairs % 2 == 0) ? (int) result : 0;
    }
        private static final int MOD = 1_000_000_007;
        private int count(int index, int seats, String corridor, Map<Pair<Integer, Integer>, Integer> cache) {
            if (index == corridor.length()) {
                return seats == 2 ? 1 : 0;
            }
            if (cache.containsKey(new Pair<>(index, seats))) {
                return cache.get(new Pair<>(index, seats));
            }
            int result = 0;
            if (seats == 2) {
                if (corridor.charAt(index) == 'S') {
                    result = count(index + 1, 1, corridor, cache);
                } else {
                    result = (count(index + 1, 0, corridor, cache) + count(index + 1, 2, corridor, cache)) % MOD;
                }
            } else {
                if (corridor.charAt(index) == 'S') {
                    result = count(index + 1, seats + 1, corridor, cache);
                } else {
                    result = count(index + 1, seats, corridor, cache);
                }
            }
            cache.put(new Pair<>(index, seats), result);
            return result;
        }


        public int numberOfWays(String corridor) {
            Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
            return count(0, 0, corridor, cache);
        }

    }

