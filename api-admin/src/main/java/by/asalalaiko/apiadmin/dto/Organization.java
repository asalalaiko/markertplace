package by.asalalaiko.apiadmin.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organizations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {


    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "organizationsIdSeq", sequenceName = "organizations_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationsIdSeq")
    private Integer id;
    @Column(name = "name",  unique = true)
    @NotNull
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "logo")
    private String logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization", fetch = FetchType.LAZY)
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "locked", nullable = false)
    private Boolean locked;
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;
}