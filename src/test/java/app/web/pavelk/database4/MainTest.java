package app.web.pavelk.database4;

import app.web.pavelk.database4.service.TopicService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {MainTest.Initializer.class})
class MainTest {

    @Autowired
    private TopicService topicService;

    @Container
    public static GenericContainer<?> mysql = new GenericContainer<>(DockerImageName.parse("mysql:8.0"))
            .withExposedPorts(3306)
//            .waitingFor(new HttpWaitStrategy().forPort(3306)
//                    .withStartupTimeout(Duration.ofMinutes(15)))
            .withEnv("MYSQL_DATABASE", "db4")
            .withEnv("MYSQL_ROOT_PASSWORD", "0");


    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + "jdbc:mysql://" + mysql.getHost() + ":" + mysql.getMappedPort(3306) + "/mysql",
                    "spring.datasource.username=root",
                    "spring.datasource.password=0",
                    "consoleExecute=false"
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    void test() {

        System.out.println("==================");
        System.out.println(mysql.getHost());
        System.out.println(mysql.getExposedPorts());
        System.out.println(mysql.getPortBindings());
        System.out.println(mysql.getContainerName());
        System.out.println(mysql.getEnvMap());
        System.out.println(mysql.getMappedPort(3306));
        System.out.println(mysql.getDockerImageName());
        System.out.println("-----------------------------------");
        Assertions.assertEquals(Boolean.TRUE, topicService.showBooks());

    }

}
