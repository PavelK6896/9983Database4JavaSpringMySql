package app.web.pavelk.database4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book", schema = "db4")
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


    @Column(name = "topic_id", nullable = false)
    private Integer topicId;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "topic_id", insertable = false, updatable = false)
    private Topic topic;

}
