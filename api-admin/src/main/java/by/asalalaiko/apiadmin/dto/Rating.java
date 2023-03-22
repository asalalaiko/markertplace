package by.asalalaiko.apiadmin.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "organizationsIdSeq", sequenceName = "ratings_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratingsIdSeq")
    private Integer id;
    @Column(name = "name",  unique = true)
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
