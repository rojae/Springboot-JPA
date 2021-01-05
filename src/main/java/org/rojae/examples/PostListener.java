package org.rojae.examples;

import org.springframework.context.event.EventListener;

public class PostListener {

    @EventListener
    public void onApplicationEvent(PostPublishEvent event){
        System.out.println("--------------------------");
        System.out.println(event.getPost().getTitle() + "is published!!");
        System.out.println("--------------------------");
    }

}
