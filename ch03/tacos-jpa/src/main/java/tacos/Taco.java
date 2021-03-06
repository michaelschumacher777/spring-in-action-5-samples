package tacos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Taco {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  private String name;

  private Date createdAt;

  @ManyToMany(targetEntity=Ingredient.class)
  @Size(min=1, message="You must choose at least 1 ingredient")
  @JoinTable(name="taco_ingredients",
          joinColumns = @JoinColumn(name = "taco_id1", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "ingredients_id1", referencedColumnName = "id", columnDefinition = "varchar(100)"))
  private List<Ingredient> ingredients = new ArrayList<>();
  
  @PrePersist
  void createdAt() {
    this.createdAt = new Date();
  }
}
