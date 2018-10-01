package com.eventroll.services.user.impl;

import com.eventroll.common.requestdto.user.UserCreationRequest;
import com.eventroll.common.requestdto.user.UserModificationRequest;
import com.eventroll.repositories.user.UserRepository;
import com.eventroll.services.user.UserService;
import com.eventroll.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Author: William Arustamyan
 * Date: 18/07/2018
 * Time: 8:49 AM
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User create(@NotNull final UserCreationRequest creationRequest) {

        final User instance = new User();
        instance.setFirstName(creationRequest.getFirstName());
        instance.setLastName(creationRequest.getLastName());
        instance.setEmailAddress(creationRequest.getEmailAddress());
        instance.setUserName(creationRequest.getUserName());
        instance.setPassword(creationRequest.getPassword());
        instance.setEnabled(true);

        User savedInstance = userRepository.save(instance);

        entityManager.flush();

        return savedInstance;
    }

    @Override
    @Transactional(readOnly = true)
    public User get(final long userId) {
        return userRepository.findByIdAndDeletedIsNull(userId);
    }

    @Override
    @Transactional
    public User update(@NotNull final UserModificationRequest modificationRequest) {
        return null;
    }

    @Override
    @Transactional
    public void delete(final long userId) {
        User found = this.get(userId);
        found.setDeleted(LocalDateTime.now());
        userRepository.save(found);
        entityManager.flush();
    }
}
