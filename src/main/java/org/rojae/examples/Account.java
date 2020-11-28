package org.rojae.examples;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Override
    public String toString(){
        return "id: "+id+", username :"+username+", password: "+ password;
    }
}
