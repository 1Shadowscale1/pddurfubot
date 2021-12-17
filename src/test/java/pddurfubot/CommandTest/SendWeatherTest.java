package pddurfubot.CommandTest;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.Location;
import pddurfubot.TestConfig;
import pddurfubot.commands.basic.SendWeather;

import java.net.MalformedURLException;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SendWeatherTest {
    TestConfig testConfig = new TestConfig();

    @Test
    public void WeatherTest()
    {
        double randomLat = ThreadLocalRandom.current().nextDouble(-90, 90);
        double randomLon = ThreadLocalRandom.current().nextDouble(-180, 180);
        Location location = new Location();
        location.setLatitude(randomLat);
        location.setLongitude(randomLon);

        testConfig.testMessage.setLocation(location);
        SendWeather sendWeather = new SendWeather();
        String answer = null;
        try {
            answer = sendWeather.getMessage(testConfig.testMessage).getText();
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
