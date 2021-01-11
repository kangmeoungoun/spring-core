package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest{

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Singletonbean.class);

        Singletonbean singletonbean1 = ac.getBean(Singletonbean.class);
        Singletonbean singletonbean2 = ac.getBean(Singletonbean.class);
        System.out.println("singletonbean1 = " + singletonbean1);
        System.out.println("singletonbean2 = " + singletonbean2);
        assertThat(singletonbean1).isSameAs(singletonbean2);
        ac.close();
    }
    @Scope("singleton")
    static class Singletonbean {

        @PostConstruct
        public void init(){
            System.out.println("Singletonbean.init");
        }
        @PreDestroy
        public void destory(){
            System.out.println("Singletonbean.destory");
        }
    }
}
