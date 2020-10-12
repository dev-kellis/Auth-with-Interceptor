package kr.kellis.aawithinterceptor.app.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String password;
    private String authority;
    private boolean enabled;
    private String name;

}
