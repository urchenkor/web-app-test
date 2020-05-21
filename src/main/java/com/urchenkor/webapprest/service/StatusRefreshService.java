package com.urchenkor.webapprest.service;

import com.urchenkor.webapprest.entity.Person;
import com.urchenkor.webapprest.entity.StatusEnum;
import com.urchenkor.webapprest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusRefreshService {
    private PersonRepos personRepos;
    private final static long POLLING_TIME = 10000; //Период опроса базы данных в мс.
    private final static long STATUS_REFRESH_TIME = 300000; //Период обновления статуса в AWAY

    @Autowired
    public StatusRefreshService(PersonRepos personRepos) {
        this.personRepos = personRepos;
    }

    @Scheduled(fixedDelay = POLLING_TIME)
    public void statusRefresher() {
        long currentTime = System.currentTimeMillis() - STATUS_REFRESH_TIME;
        List<Person> onlinePersons = personRepos.findByTimeStampLessThanEqualAndStatus(
                currentTime, StatusEnum.ONLINE);
        for (Person p : onlinePersons) p.setStatus(StatusEnum.AWAY);

        personRepos.saveAll(onlinePersons);
    }

}
