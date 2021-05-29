package app.web.pavelk.database4.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topic", schema = "db4")
public class Topic {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @JsonBackReference
    @OneToMany(mappedBy = "topic", cascade = CascadeType.MERGE)
    private List<Book> books;

}
