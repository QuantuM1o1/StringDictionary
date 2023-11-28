package REST.Spring.Dictionary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class StringReader
{
    private final static Logger LOGGER = LogManager.getLogger();

    @PostMapping("/string")
    public Map<Character, Integer> get(@RequestBody String string)
    {
        Map<Character, Integer> map = MapCreator.createMap(string);
        LOGGER.info(map);
        return map;
    }
}
