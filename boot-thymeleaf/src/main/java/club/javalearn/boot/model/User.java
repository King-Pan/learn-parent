package club.javalearn.boot.model;

import lombok.Data;

import java.util.Date;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-14
 **/
@Data
public class User {
    private String userName;
    private String nikeName;
    private Integer age;
    private String roleName;
    private Date lastLoginTime;
}
