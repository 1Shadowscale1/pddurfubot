package pddurfubot.WeatherApiTest;

import org.junit.jupiter.api.Test;
import pddurfubot.weatherAPI.Weather;

import java.net.MalformedURLException;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiRequestTest {
    @Test
    public void ApiAnswerTest(){
        double randomLat = ThreadLocalRandom.current().nextDouble(-90, 90);
        double randomLon = ThreadLocalRandom.current().nextDouble(-180, 180);
        String answer = null;
        try {
            answer = Weather.ApiRequest(randomLat, randomLon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        assert answer != null;
        assertTrue(answer.contains("Восход солнца:") &
                answer.contains("Заход солнца:") &
                answer.contains("Температура:") &
                answer.contains("По ощущениям:"));
    }
}
