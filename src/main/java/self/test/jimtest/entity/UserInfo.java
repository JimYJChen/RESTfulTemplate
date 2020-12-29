package self.test.jimtest.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键

    @Column(nullable = false)
    private String firstName;//名

    @Column(nullable = false)
    private String lastName;//姓

    @Column(nullable = false)
    private String idCard;//身份证

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;//出生日期
}
