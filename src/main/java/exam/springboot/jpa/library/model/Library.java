package exam.springboot.jpa.library.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "library")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    @Id
    private Long lbno;

    private String lbname;
    private String sido;
    private String gugun;
    private String lbtype;
    private String clsday;
    private String addr;
    private String phone;
    private String hp;
    private Double lat;
    private Double lon;

    @CreatedDate
    @Column(insertable = false, updatable = false)
    private LocalDateTime reg;
}
