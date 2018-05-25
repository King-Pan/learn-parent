package club.javalearn.boot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author king-pan
 */
@Data
public class Employee implements Serializable {
    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;
}
