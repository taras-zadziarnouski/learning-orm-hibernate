package by.zadziarnouski.learningormhibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_test")
public class User {

  @Id
  private long id;
  private String firstname;
  private String lastname;
  private Integer age;
}
