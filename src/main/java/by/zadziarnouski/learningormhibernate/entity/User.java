package by.zadziarnouski.learningormhibernate.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_test")
public class User {

  @EmbeddedId
  private UserId id;
  private Integer age;
}
