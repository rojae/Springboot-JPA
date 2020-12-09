package org.rojae.examples;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/*
    @EnableJpaRepositories 의 빈 등록은 어찌 할까?
    @EnableJpaRepositories - @JpaRepositoriesRegistrar - @ImportBeanDefinitionRegistrar
    ImportBeanDefinitionRegistrar의 빈 등록 방법 테스트
 */
public class RojaeRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Rojae.class);
        beanDefinition.getPropertyValues().add("name", "rojae");

        registry.registerBeanDefinition("rojae", beanDefinition);
    }
}
