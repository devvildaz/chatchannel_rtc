package org.devvildaz.chatchannel.services;

import org.devvildaz.chatchannel.models.AppUser;
import org.devvildaz.chatchannel.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserService {
    @Autowired
    public AppUserRepository _userRepository;

    public List<AppUser> getAllUsers() {
        List<AppUser> users = _userRepository.findAll();
        return users;
    }
}
