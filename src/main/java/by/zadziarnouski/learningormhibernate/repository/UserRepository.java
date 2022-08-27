package by.zadziarnouski.learningormhibernate.repository;

import by.zadziarnouski.learningormhibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByIdFirstname(String firstname);

  @Query("SELECT U FROM User U WHERE U.id.firstname = ?1")
  User findByIdFirstnameWithJPQL(String firstName);

  @Query(value = "SELECT * FROM \"user\" WHERE \"firstname\" = ?1", nativeQuery = true)
  User findByIdFirstnameWithNativeQuery(String firstname);
}
