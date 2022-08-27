package by.zadziarnouski.learningormhibernate.controller;

import by.zadziarnouski.learningormhibernate.entity.UserProfile;
import by.zadziarnouski.learningormhibernate.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-profiles")
public class UserController {

  private final UserProfileService userProfileService;

  @Autowired
  public UserController(UserProfileService userProfileService) {
    this.userProfileService = userProfileService;
  }

  @GetMapping("/find-by-id/{id}")
  public UserProfile findById(@PathVariable("id") Long id) {
    return userProfileService.findUserProfileByProfileId(id);
  }
}
