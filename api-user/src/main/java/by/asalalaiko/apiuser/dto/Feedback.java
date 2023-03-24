package by.asalalaiko.apiuser.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "feedbackIdSeq", sequenceName = "feedback_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedbackIdSeq")
    private Integer id;
    @Column(name = "name",  unique = true)
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
