package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.LoginRequestDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.UserDto;
import rs.ac.uns.ftn.portal_organa_vlasti.model.user.User;
import rs.ac.uns.ftn.portal_organa_vlasti.repository.UserRepository;
import rs.ac.uns.ftn.portal_organa_vlasti.security.JwtUtil;

@Service
public class AuthUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public void registerUser(User user) throws Exception {
        userRepository.create(user);
    }

    public UserDto login(LoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        User user = (User) authentication.getPrincipal();
        String token = jwtUtil.createJwt(user);

        return new UserDto(user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole(), token);
    }
}
