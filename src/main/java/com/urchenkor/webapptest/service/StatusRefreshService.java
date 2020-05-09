package com.urchenkor.webapptest.service;

import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;
import com.urchenkor.webapptest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusRefreshService {
    private PersonRepos personRepos;
    private final static long TIMER = 10000; //Время опроса базы данных в мс.

    @Autowired
    public StatusRefreshService(PersonRepos personRepos) {
        this.personRepos = personRepos;
    }

    @Scheduled(fixedDelay = TIMER / 2)
    public void statusRefresher() {
        long currentTime = System.currentTimeMillis() - TIMER;
        List<Person> onlinePersons = personRepos.findByTimeStampLessThanEqualAndStatus(
                currentTime, StatusEnum.ONLINE);
        for (Person p : onlinePersons) p.setStatus(StatusEnum.AWAY);

        personRepos.saveAll(onlinePersons);
    }

}
