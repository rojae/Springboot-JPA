package org.rojae.examples;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany
    private Set<Study> studies = new HashSet<>();

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
