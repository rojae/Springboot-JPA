package org.rojae.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
원래 @Configuration이 설정되어 있는 클래스에
@EnableJpaRepositories를 추가를 해줘야 하지만
하지만 이게 없어도 된다. 스프링 부트가 해주고 있음

@SpringBootApplication annotation 자체가 configuration이며
@EnableJpaRepositores (@Import JpaRepositoriesRegistrar.class)
를 자동으로 해주기 때문이다.

스프링 문서에도 '@SpringBootApplication은
@EnableJpaRepositories를 통해 JPA 리퍼지토리들을 등록해줍니다.'
@EnableJpaRepositories - @JpaRepositoriesRegistrar - @ImportBeanDefinitionRegistrar
라고만 설명되어있다.
 */
@SpringBootApplication
@Import(RojaeRegistrar.class)           // bean 등록
@EnableJpaRepositories(repositoryBaseClass = CommonRepositoryImpl.class)       // 공통 레파지토리를 baseClass로 알려줌
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

}
