package REST.Spring.Dictionary;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapCreator
{
    public static Map<Character, Integer> createMap(String string)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : string.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }
}
