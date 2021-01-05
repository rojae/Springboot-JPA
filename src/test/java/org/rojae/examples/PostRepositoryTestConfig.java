package org.rojae.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// DataJpaTest를 통해서는 Configuration 인식을 못하기 때문에
// 직접 넣어줌

@Configuration
public class PostRepositoryTestConfig {

    @Bean
    public PostListener postListener(){
        return new PostListener();
    }

}
