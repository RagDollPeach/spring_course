package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.SubscribeForm;
import java.util.ArrayList;
import java.util.List;

public class SubscriberRepository implements ProjectRepository<SubscribeForm>{

    private final Logger logger = Logger.getLogger(SubscriberRepository.class);
    private final List<SubscribeForm> subscribers = new ArrayList<>();

    @Override
    public List<SubscribeForm> retreiveAll() {
        return new ArrayList<>(subscribers);
    }

    @Override
    public void store(SubscribeForm subscribeForm) {
        subscribeForm.setId(subscribeForm.hashCode());
        logger.info("Store new subscriber " + subscribeForm);
        subscribers.add(subscribeForm);
    }

    @Override
    public boolean removeItemById(Integer SubToRemove) {
        for (SubscribeForm form : retreiveAll()) {
            if (form.getId().equals(SubToRemove)) {
                logger.info("remove subscriber completed: " + form);
                return subscribers.remove(form);
            }
        }
        return false;
    }
}
