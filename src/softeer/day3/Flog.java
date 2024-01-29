package softeer.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Flog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] nums = getNums(br);
        int [] weights = getNums(br);
        Set<Integer> relations = new HashSet<>(nums[1]);
        int[] memorise = new int[nums[0]];

        for (int i=0; i < nums[1]; i++) {
            int[] infos = getNums(br);
            int a = infos[0],   b = infos[1];

            if (weights[a-1] > weights[b-1]) {
                relations.remove(b);
                if (memorise[a-1] == 0) relations.add(a);
            }
            else if (weights[a-1] < weights[b-1]){
                relations.remove(a);
                if (memorise[b-1] == 0) relations.add(b);
            }
            else {
                relations.remove(a);
                relations.remove(b);
            }

            memorise[a-1] = -1;   memorise[b-1] = -1;
        }

        int count = (int)Arrays.stream(memorise)
                                        .filter(value -> value != -1)
                                        .count();

        System.out.println(count + relations.size());
    }

    private static int[] getNums(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
