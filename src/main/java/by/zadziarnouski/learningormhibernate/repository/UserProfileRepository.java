package by.zadziarnouski.learningormhibernate.repository;

import by.zadziarnouski.learningormhibernate.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

  UserProfile findUserProfileByProfileId(Long id);
}
