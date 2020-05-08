package com.urchenkor.webapptest.service;

import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;
import com.urchenkor.webapptest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;
import java.util.stream.Stream;

@Component
public class StatusRefreshService {
    private static final String CRON = "*/10 * * * * *";
    private PersonRepos personRepos;
    private static Person staticPerson;

    @Autowired
    public StatusRefreshService(PersonRepos personRepos) {
        this.personRepos = personRepos;
    }

    @Scheduled(fixedDelay = 100)
    public void statusRefresher() throws InterruptedException {
        List<Person> onlinePersons = personRepos.findByStatus(StatusEnum.ONLINE);
        for (Person p : onlinePersons) refreshStatus(p);
    }

    public void refreshStatus(Person person) throws InterruptedException {
        Optional<Person> p1 = personRepos.findById(person.getId());
        Person personFromDb1 = p1.get();
        long timeStamp1 = personFromDb1.getTimeStamp();
        long currentTime = System.currentTimeMillis();
        long timer = 10000 - (currentTime - timeStamp1);
        Thread.sleep(timer);

        Optional<Person> p2 = personRepos.findById(person.getId());
        Person personFromDb2 = p2.get();
        long timeStamp2 = personFromDb2.getTimeStamp();
        if (timeStamp1 != timeStamp2) {
            refreshStatus(personFromDb2);
        }
        else {
            personFromDb1.setStatus(StatusEnum.AWAY);
            personRepos.save(personFromDb1);
        }
    }
}
