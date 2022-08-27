package by.zadziarnouski.learningormhibernate.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import by.zadziarnouski.learningormhibernate.entity.User;
import by.zadziarnouski.learningormhibernate.entity.UserId;
import by.zadziarnouski.learningormhibernate.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    UserId userId = new UserId();
    userId.setFirstname("foo");
    userId.setLastname("bar");
    User user = new User();
    user.setId(userId);
    user.setAge(28);

    userRepository.save(user);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void findByFirstName() throws Exception {
    mockMvc.perform(get("/users/find-by-firstname/foo"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id.firstname").value("foo"))
        .andExpect(jsonPath("$.id.lastname").value("bar"))
        .andExpect(jsonPath("$.age").value(28));
  }
}