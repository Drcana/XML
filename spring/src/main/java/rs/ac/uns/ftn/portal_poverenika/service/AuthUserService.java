package rs.ac.uns.ftn.portal_poverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.repository.UserRepository;

@Service
public class AuthUserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) throws Exception {
        userRepository.create(user);
    }
}
