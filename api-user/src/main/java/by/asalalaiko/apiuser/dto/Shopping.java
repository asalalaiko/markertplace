package by.asalalaiko.apiuser.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shopping")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shopping {

    @Id
    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(name = "date")
    @NotNull
    private Date date;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;
}