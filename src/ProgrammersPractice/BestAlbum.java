package ProgrammersPractice;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playGenres = new HashMap<>();
        for (int i=0; i< genres.length; i++) {
            playGenres.put(genres[i], playGenres.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> sortedGenres = playGenres.keySet().stream()
                .sorted((o1, o2) -> playGenres.get(o2) - playGenres.get(o1))
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedGenres){
            Map<Integer, Integer> genresBest = new HashMap<>();
            for (int i=0; i< genres.length; i++){
                if (genre.equals(genres[i])) {
                    genresBest.put(i, plays[i]);
                }
            }
            List<Integer> keyIdx = genresBest.keySet().stream()
                    .sorted((o1, o2) -> genresBest.get(o2) - genresBest.get(o1))
                    .collect(Collectors.toList());
            answer.add(keyIdx.get(0));
            if (keyIdx.size()>1) answer.add(keyIdx.get(1));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        new BestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
