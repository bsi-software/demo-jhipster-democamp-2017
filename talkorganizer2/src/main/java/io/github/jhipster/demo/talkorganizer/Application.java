package io.github.jhipster.demo.talkorganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ServletConfiguration.class})
@ComponentScan(basePackages = "org.eclipse.scout.boot")
public class Application {

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
