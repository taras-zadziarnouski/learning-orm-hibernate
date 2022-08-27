package by.zadziarnouski.learningormhibernate.service;


import by.zadziarnouski.learningormhibernate.entity.UserProfile;
import by.zadziarnouski.learningormhibernate.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserProfileService implements UserProfileService {

  private final UserProfileRepository userProfileRepository;

  @Autowired
  public DefaultUserProfileService(UserProfileRepository userProfileRepository) {
    this.userProfileRepository = userProfileRepository;
  }

  @Override
  public UserProfile findUserProfileByProfileId(Long id) {
    return userProfileRepository.findUserProfileByProfileId(id);
  }
}
