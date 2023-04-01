package by.asalalaiko.apiuser.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
    @NotNull
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "quantity", columnDefinition = "integer default 0")
    private Integer quantity;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Feedback> feedback;
    @Column(name = "tags")
    private String tags;
    @Column(name = "specifications")
    private String specifications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Rating> rating;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "discounts_products",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "discount_id") })
    private Set<Discount> discounts = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Shopping> shoppingList;
    @Column(name = "locked", nullable = false)
    private Boolean locked;
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;
}
