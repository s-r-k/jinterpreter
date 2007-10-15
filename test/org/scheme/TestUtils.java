package org.scheme;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public static List listify(String... words) {
        List<String> list = new ArrayList<String>();
        for (String word : words)
            list.add(word);
        return list;
    }
}
