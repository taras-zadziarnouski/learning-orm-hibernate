package by.zadziarnouski.learningormhibernate.service;


import by.zadziarnouski.learningormhibernate.entity.User;
import by.zadziarnouski.learningormhibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public DefaultUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findByFirstname(String firstname) {
    return userRepository.findByIdFirstname(firstname);
  }
}
