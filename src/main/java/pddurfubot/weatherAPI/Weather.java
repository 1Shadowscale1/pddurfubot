package pddurfubot.weatherAPI;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class Weather {
    public static String ApiRequest(double lat, double lon) throws MalformedURLException {
        int time = (int) Instant.now().getEpochSecond();
        URL url = new URL("http://api.openweathermap.org/data/2.5/onecall/timemachine?" +
                "lat=" + lat + "&lon=" + lon + "&dt=" + time + "&lang=ru&appid=2581798ff1888af2ec49ad76e7220608");
        URL url2 = new URL("http://api.positionstack.com/v1/reverse?access_key=5fe64276bc2616a8d6d17d01749756dd" +
                "&query=" + lat + ", " + lon);

        Map jsonMap = HandleApiRequest(url);
        Map jsonMap2 = HandleApiRequest(url2);

        Map currentWeather = (Map) jsonMap.get("current");
        String sunrise = ConvertSecondsToDate((int) currentWeather.get("sunrise"));
        String sunset = ConvertSecondsToDate((int) currentWeather.get("sunset"));
        String temp = String.valueOf((int) Math.round((double)currentWeather.get("temp")-273.15));
        String tempFeel = String.valueOf((int) Math.round((double)currentWeather.get("feels_like")-273.15));
        Map description = (Map) ((ArrayList)currentWeather.get("weather")).get(0);

        Object geoInfo = jsonMap2.get("data");
        Map currentLocation = (Map) ((ArrayList)geoInfo).get(0);


        return currentLocation.get("label") + "\n" +
                "Восход солнца: " + sunrise + "\n" +
                "Заход солнца: " + sunset + "\n" +
                "Температура: " + temp + "\n" +
                "По ощущениям: " + tempFeel + "\n" +
                description.get("description");
    }

    private static String ConvertSecondsToDate(int seconds){
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.MIN);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM, HH:mm", new Locale("ru"));
        return dateTime.format(formatter);
    }

    private static Map HandleApiRequest(URL url){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader((url).openConnection()
                    .getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        Map jsonMap = null;
        try {
            jsonMap = mapper.readValue(reader, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert jsonMap!=null;
        return jsonMap;
    }
}
