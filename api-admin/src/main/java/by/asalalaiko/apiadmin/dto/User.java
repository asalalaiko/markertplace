package by.asalalaiko.apiadmin.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "usersIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdSeq")
    private Integer id;
    @Column(name = "username",  unique = true)
    @NotNull
    private String username;
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "password")
    private String password;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "locked", nullable = false)
    private Boolean locked;
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Message> messages;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Shopping> shoppingList;

}
