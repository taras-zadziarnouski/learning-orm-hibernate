package by.zadziarnouski.learningormhibernate.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UserId implements Serializable {

  private String firstname;
  private String lastname;
}
