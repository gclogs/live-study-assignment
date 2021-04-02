import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("key01", "value01");
        map.put("key02", "value02");
        map.put("key03", "value03");
        map.put("key04", "value04");
        map.put("key05", "value05");

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        });

        map.keySet().forEach(key -> {
            System.out.println(key + ", " + map.get(key));
        });





    }


}
