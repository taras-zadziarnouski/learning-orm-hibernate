package by.zadziarnouski.learningormhibernate.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import by.zadziarnouski.learningormhibernate.entity.User;
import by.zadziarnouski.learningormhibernate.entity.UserProfile;
import by.zadziarnouski.learningormhibernate.repository.UserProfileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UserProfileControllerTest {

  @Autowired
  private UserProfileRepository userProfileRepository;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    User user = new User();
    user.setId(1);
    user.setFirstname("foo");
    user.setLastname("bar");
    user.setAge(28);

    UserProfile userProfile = new UserProfile();
    userProfile.setUser(user);

    userProfileRepository.save(userProfile);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void findByFirstName() throws Exception {
    mockMvc.perform(get("/user-profiles/find-by-id/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.profileId").value(1))
        .andExpect(jsonPath("$.user.id").value(1))
        .andExpect(jsonPath("$.user.firstname").value("foo"))
        .andExpect(jsonPath("$.user.lastname").value("bar"))
        .andExpect(jsonPath("$.user.age").value(28));
  }
}