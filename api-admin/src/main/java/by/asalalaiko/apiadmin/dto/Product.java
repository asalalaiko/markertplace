package by.asalalaiko.apiadmin.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "productsIdSeq", sequenceName = "products_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productsIdSeq")
    private Integer id;
    @Column(name = "name",  unique = true)
    @NotNull
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
    @NotNull
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "quantity", columnDefinition = "integer default 0")
    private Integer quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Feedback> feedback;
    @Column(name = "tags")
    private String tags;
    @Column(name = "specifications")
    private String specifications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Rating> rating;
}
