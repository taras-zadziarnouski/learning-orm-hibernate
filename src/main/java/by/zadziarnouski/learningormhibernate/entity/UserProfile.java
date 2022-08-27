package by.zadziarnouski.learningormhibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class UserProfile {

  @Id
  private Long profileId;

  @OneToOne
  @MapsId
  private User user;
}
