package study.open_weather_map_ex;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/address")
    public String showWeather(@RequestParam("address") String address, Model model)  {
        Map<String, String> lanLon = weatherService.returnLanLon(address);

        model.addAttribute("weather", weatherService.returnWeather(lanLon));
        return "index";
    }
}
