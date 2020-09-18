package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Birthday;
import edu.wctc.distjavazodiac.entity.Fortune;
import edu.wctc.distjavazodiac.entity.Horoscope;
import edu.wctc.distjavazodiac.repository.FortuneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseFortuneService implements HoroscopeService{
    private List<Fortune> allFortunes;
    @Autowired
    private ZodiacService zodiacService;
    @Autowired
    private FortuneRepo fRepo;

    @Override
    public Horoscope getHoroscope(Birthday birthday) {
        String sign;
        if (birthday.getZodiacType().toLowerCase().startsWith("w")) {
            sign = zodiacService.getWesternZodiacSign(birthday);
        } else {
            sign = zodiacService.getEasternZodiacSign(birthday);
        }

        Horoscope hscope = new Horoscope();
        hscope.setSign(sign);

        int randomIndex = (int) (Math.random() * allFortunes.size());
        hscope.setHoroscope(allFortunes.get(randomIndex).getText());
        return hscope;
    }
    @PostConstruct
    public void initHoroscopes(){
        allFortunes=new ArrayList<>();
        fRepo.findAll().forEach(allFortunes::add);
    }
}
