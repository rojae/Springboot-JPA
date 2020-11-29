package org.rojae.examples;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date created = new Date();

    @Transient
    private String po;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name="home_street"))
    })
    private Address address;

    @Override
    public String toString(){
        return "id: "+id+", username :"+username+", password: "+ password + ", createdDate: "+created;
    }
}
