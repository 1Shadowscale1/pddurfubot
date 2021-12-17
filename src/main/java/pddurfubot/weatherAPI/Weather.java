package pddurfubot.weatherAPI;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Map;

public class Weather {
    public static String ApiRequest(double lat, double lon) throws MalformedURLException {
        int time = (int) new Date().getTime()/1000;
        URL url = new URL("https://api.openweathermap.org/data/2.5/onecall/timemachine?lat=" + lat + "&lon="
                + lon + "&dt=" + time + "&appid=2581798ff1888af2ec49ad76e7220608");

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert connection != null;
        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = null;
        try {
            responseStream = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = null;
        try {
            jsonMap = mapper.readValue(responseStream, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert jsonMap != null;
        return jsonMap.toString();
    }
}
