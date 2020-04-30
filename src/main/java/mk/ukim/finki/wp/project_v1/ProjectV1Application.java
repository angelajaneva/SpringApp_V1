package mk.ukim.finki.wp.project_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class ProjectV1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectV1Application.class, args);
    }

}
