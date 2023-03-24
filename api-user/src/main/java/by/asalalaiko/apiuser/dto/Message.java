package by.asalalaiko.apiuser.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Message {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "messagesIdSeq", sequenceName = "messages_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messagesIdSeq")
    private Integer id;
    @Column(name = "title")
    @NotNull
    private String title;
    @CreatedDate
    @Column(name = "date")
    @NotNull
    private Date date;
    @Column(name = "text_message")
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
