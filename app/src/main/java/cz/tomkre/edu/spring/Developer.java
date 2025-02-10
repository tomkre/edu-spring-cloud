package cz.tomkre.edu.spring;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data @NoArgsConstructor @AllArgsConstructor
public class Developer {
    @Id
    private String name;
    private String category;
    private Integer level;
    public static Developer of(String name, String category, Integer level) {
        return new Developer(name, category, level);
    }
}
