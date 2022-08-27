package by.zadziarnouski.learningormhibernate.service;

import by.zadziarnouski.learningormhibernate.entity.UserProfile;
import org.springframework.stereotype.Service;

@Service
public interface UserProfileService {

  UserProfile findUserProfileByProfileId(Long id);
}
