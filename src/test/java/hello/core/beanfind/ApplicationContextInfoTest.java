package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean :
                beanDefinitionNames) {
            Object object = ac.getBean(bean);
            System.out.println("name = " + beanDefinitionNames + "  object = " + object);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(bean);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object object = ac.getBean(bean);
                System.out.println("name = " + beanDefinitionNames + "  object = " + object);
            }
        }
    }
}
