package by.zadziarnouski.learningormhibernate.service;

import by.zadziarnouski.learningormhibernate.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  User findByFirstname(String firstname);
}
