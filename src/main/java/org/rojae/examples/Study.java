package org.rojae.examples;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Study {

    @Id @GeneratedValue
    private Long id;

    private String name;

    // study 입장에서는 many to one
    // study table에서 외래키 생성 (owner의 .id를 찾아감)
    @ManyToOne
    private Account owner;

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    @Override
    public String toString(){
        return "id : "+id+", name: "+name+", owner: "+ owner.getUsername();
    }
}
