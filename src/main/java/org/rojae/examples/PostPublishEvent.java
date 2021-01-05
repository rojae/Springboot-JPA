package org.rojae.examples;

import org.springframework.context.ApplicationEvent;

public class PostPublishEvent extends ApplicationEvent {
    private final Post post;

    public PostPublishEvent(Object source) {
        super(source);
        this.post = (Post) source;
    }

    public Post getPost(){
        return this.post;
    }

}
