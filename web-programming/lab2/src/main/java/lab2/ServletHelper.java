package lab2;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ServletHelper {
    static void setAttributes(HttpServletRequest request) throws IOException {
        var body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())).split("&");
        var map = new HashMap<String, String>();
        for (String s : body) {
            var x = s.split("=");
            map.put(x[0], x[1]);
        }
        map.forEach(request::setAttribute);
    }
}
