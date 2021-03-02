package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.dbproxy.JdkRepositoryProxy;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2021/03/01
 */
public class UserServiceImpl implements UserService {

    UserRepository userRepository = JdkRepositoryProxy.create(UserRepository.class);

    @Override
    public boolean register(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
