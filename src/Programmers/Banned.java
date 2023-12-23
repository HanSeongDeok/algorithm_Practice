package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Banned {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String >> set = new HashSet<>();
        set = bannedDfs(set, user_id, banned_id, 0, new HashSet<>());
        return set.size();
    }
    //TODO 복습
    private Set<Set<String>> bannedDfs(Set<Set<String>> setResult, String[] userIds, String[] bannedIds, int depth, Set<String> set) {
        boolean check = true;
        if (bannedIds.length == depth) {
            setResult.add(set);
            return setResult;
        }

        for (int i=0; i < userIds.length; i++) {
            if (set.contains(userIds[i]) || userIds[i].length() != bannedIds[depth].length()) continue;
            for (int j = 0; j < userIds[i].length(); j++) {
                if (bannedIds[depth].charAt(j) != '*' && bannedIds[depth].charAt(j) != userIds[i].charAt(j)) {
                    check = false; break;
                }
                check = true;
            }
            if (check) {
                set.add(userIds[i]);
                setResult = bannedDfs(setResult, userIds, bannedIds, depth+1, new HashSet<>(set));
                set.remove(userIds[i]);
            }
        }
        return setResult;
    }

    public static void main(String[] args) {
        new Banned().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
    }
}
