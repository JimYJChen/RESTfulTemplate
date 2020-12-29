package self.test.jimtest.beans;

import lombok.Data;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class TestResponse extends AtomResponse{

    private String name;

    private String value;
}
