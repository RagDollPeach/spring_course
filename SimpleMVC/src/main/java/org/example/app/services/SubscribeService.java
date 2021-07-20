package org.example.app.services;

import org.example.web.dto.SubscribeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {

    private final ProjectRepository<SubscribeForm> subscribeRepo;

    @Autowired
    public SubscribeService(ProjectRepository<SubscribeForm> subscribeRepo) {
        this.subscribeRepo = subscribeRepo;
    }

    public List<SubscribeForm> getAllSubscribers() {
        return subscribeRepo.retreiveAll();
    }

    public void saveSubscriber(SubscribeForm subscribeForm) {
        subscribeRepo.store(subscribeForm);
    }

    public boolean removeSubscriberById(Integer subscriberId) {
        return subscribeRepo.removeItemById(subscriberId);
    }
}
