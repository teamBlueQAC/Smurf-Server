package com.qa.smurf.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.qa.smurf.model.UserModel;

import java.util.logging.Logger;

@Stateless
public class UserService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<UserModel> userEvent;

    public void add(UserModel user) throws Exception {
        em.persist(user);
        userEvent.fire(user);
    }
    
}
