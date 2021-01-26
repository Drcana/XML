package rs.ac.uns.ftn.portal_poverenika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.portal_poverenika.dto.LoginRequestDto;
import rs.ac.uns.ftn.portal_poverenika.dto.UserDto;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.service.AuthUserService;

@RestController
@RequestMapping(value = "/api/auth",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
public class AuthenticationController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user) throws Exception {
        authUserService.registerUser(user);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return new ResponseEntity<>(authUserService.login(loginRequestDto), HttpStatus.OK);
    }
}
