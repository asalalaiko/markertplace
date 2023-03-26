package by.asalalaiko.apiadmin.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "discounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "discountsIdSeq", sequenceName = "discounts_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discountsIdSeq")
    private Integer id;
    @Column(name = "amount")
    @DecimalMax(value = "0.99", inclusive = true) @DecimalMin(value ="0.01", inclusive = true)
    @NotNull
    private Double amount;
    @Column(name = "until")
    @NotNull
    private Date until;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "discounts")
    private Set<Product> products = new HashSet<>();


}
