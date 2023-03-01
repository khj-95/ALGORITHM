package Programmers.test;

import java.util.Objects;
import org.json.JSONObject;

public class RemoveCharacterFromString {public static void main(String[] args) {
    String s = "123456789";
    int n = 3;

    JSONObject result = removeCharacter(s, n);

    System.out.println(result);

}

    private static JSONObject removeCharacter(String s, int n) {
        JSONObject jsonObject = new JSONObject();
        StringBuilder processed = new StringBuilder();
        StringBuilder removed = new StringBuilder();

        jsonObject.put("processed", JSONObject.NULL);
        jsonObject.put("removed", JSONObject.NULL);

        if (Objects.isNull(s)) {
            jsonObject.put("result", -2);
            return jsonObject;
        }

        if (n > s.length()) {
            jsonObject.put("result", -1);
            return jsonObject;
        }

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if ((i + 1) % n == 0) {
                removed.append(now);
                continue;
            }
            processed.append(now);
        }

        jsonObject.put("processed", processed.toString());
        jsonObject.put("removed", removed.toString());
        jsonObject.put("result", 0);

        return jsonObject;
    }
}
