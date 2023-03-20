package top.flobby.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 针对 comment 表的实体类
 * @create : 2023-03-20 14:09
 **/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "t_comment")
public class Discuss  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String content;
    private String author;

    @Column(name = "a_id")
    private Integer AId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Discuss discuss = (Discuss) o;
        return getId() != null && Objects.equals(getId(), discuss.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
