package match.week187;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 5400 旅行终点站
 * @author: ChaiRJ
 * @create: 2020-05-03 10:31
 **/
public class DestCity {
    public String destCity(List<List<String>> paths){
        Map<String,String> map= new HashMap<>();
        String begin=paths.get(0).get(0);
        String end=paths.get(0).get(1);
        for (List<String> path : paths) {
            map.put(path.get(0),path.get(1));
        }

        while (map.containsKey(end)){
            end=map.get(end);
        }
        return end;
    }
}
