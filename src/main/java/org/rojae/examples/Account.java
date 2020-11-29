package org.rojae.examples;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
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

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name="home_street"))
    })
    private Address address;

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }

    @Override
    public String toString(){
        String list = "";
        for(Study study : studies){
            list += study.getName();
        }

        return "id: "+id+", username :"+username+", password: "+ password + ", createdDate: "+created
                +", studies : " + list;
    }

}
