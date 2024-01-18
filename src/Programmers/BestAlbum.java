package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresMap = new HashMap<>();
        for (int i=0; i< genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> keys = genresMap.keySet().stream()
                .sorted((o1, o2) -> genresMap.get(o2) - genresMap.get(o1))
                .toList();

        List<Integer> answer = new ArrayList<>();
        keys.stream()
                .map(s -> createBestIdxs(genres, plays, s))
                .forEach(idx -> settingAnswer(answer, idx));

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void settingAnswer(List<Integer> answer, List<Integer> idx) {
        answer.add(idx.get(0));
        if (idx.size() > 1) answer.add(idx.get(1));
    }

    private List<Integer> createBestIdxs(String[] genres, int[] plays, String s) {
        Map<Integer, Integer> playMap = new HashMap<>();
        IntStream.range(0, genres.length)
                .filter(i -> s.equals(genres[i]))
                .forEach(i -> playMap.put(i, plays[i]));

        List<Integer> bestIdx = new ArrayList<>(playMap.keySet());
        return bestIdx.stream()
                .sorted((o1, o2) -> playMap.get(o2) - playMap.get(o1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new BestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
