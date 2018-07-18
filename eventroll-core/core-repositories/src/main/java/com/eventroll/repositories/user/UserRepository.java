package com.eventroll.repositories.user;

import com.eventroll.entity.user.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Author: William Arustamyan
 * Date: 18/07/2018
 * Time: 8:57 AM
 */

public interface UserRepository extends CrudRepository<User, Long> {
}
