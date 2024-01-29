package study;

import java.io.*;
import java.util.*;

public class MultipleMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>(index);

        for (int i=0; i < index; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(list);

        System.out.println(pq.poll() * pq.poll());
    }
}
