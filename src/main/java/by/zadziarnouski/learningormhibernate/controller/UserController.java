package by.zadziarnouski.learningormhibernate.controller;

import by.zadziarnouski.learningormhibernate.entity.User;
import by.zadziarnouski.learningormhibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/find-by-firstname/{firstname}")
  public User findByFirstName(@PathVariable("firstname") String firstname) {
    return userService.findByFirstname(firstname);
  }
}
