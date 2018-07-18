package com.eventroll.services.user;

import com.eventroll.common.requestdto.user.UserCreationRequest;
import com.eventroll.common.requestdto.user.UserModificationRequest;
import com.eventroll.entity.user.User;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 18/07/2018
 * Time: 8:48 AM
 */

public interface UserService {

    User create(@NotNull UserCreationRequest creationRequest);

    User get(long userId);

    User update(@NotNull UserModificationRequest modificationRequest);

    void delete(long userId);

}
