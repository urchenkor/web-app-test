package com.urchenkor.webapptest.service;

import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;
import com.urchenkor.webapptest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StatusRefreshService {
    private PersonRepos personRepos;

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
        Optional<Person> optional1 = personRepos.findById(person.getId());
        Person personFromDb1 = optional1.get();
        long timeStamp1 = personFromDb1.getTimeStamp();
        long currentTime = System.currentTimeMillis();
        long timer = 300000 - (currentTime - timeStamp1);
        Thread.sleep(timer);

        Optional<Person> optional2 = personRepos.findById(person.getId());
        Person personFromDb2 = optional2.get();
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
