package softeer.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int []infos = Arrays.stream(br.readLine().split(" "))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();

        Map<String, Set<Integer>> rooms = new HashMap<>();
        for (int i=0; i < infos[0]; i++) {
            rooms.put(br.readLine(), new HashSet<>());
        }

        for (int i=0; i< infos[1]; i++) {
            String[] reservation = br.readLine().split(" ");
            int count = 0;
            int start = Integer.parseInt(reservation[1]), end = Integer.parseInt(reservation[2]);
            while (start < end) {
                rooms.get(reservation[0]).add(start++);
            }
        }

        List<String> results = new ArrayList<>();
        rooms.keySet().stream().sorted().forEach(s -> {
            int start = 9, end = 18, count = 0;
            String message = "Room " + s + ":\n";
            String countMessage = " available\n";
            String time = "";
            while (start < end) {
                boolean add = rooms.get(s).add(start);
                if (add) {
                    count++;
                    time += start==9 ? "0"+ start++ + "-" : start++ + "-";
                    while (start < end && rooms.get(s).add(start)) {
                        start++;
                    }
                    time += start+"\n";
                } else start ++;
            }
            message += count == 0 ? "Not" + countMessage : count + "available:\n";
            results.add(message + time + "-----");
        });
        String replaceLastMessage = results.get(results.size() - 1).replace("\n-----", "");
        results.remove(results.get(results.size()-1));
        results.add(replaceLastMessage);
        results.forEach(System.out::println);
    }
}