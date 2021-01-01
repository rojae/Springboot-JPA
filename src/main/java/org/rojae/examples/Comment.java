package org.rojae.examples;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    @NonNull
    private Integer likeCount = 0;

    @NonNull
    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(@NonNull Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Post getPost() {
        return post;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
