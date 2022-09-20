package me.study.demomongo;

import me.study.demomongo.example2.Address;
import me.study.demomongo.example2.Gender;
import me.study.demomongo.example2.Student;
import me.study.demomongo.example2.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemomongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemomongoApplication.class, args);
    }



    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new Address(
                    "한국",
                    "사을",
                    "111"
            );
            Student student = Student.builder()
                    .firstName("홍")
                    .lastname("1")
                    .email("test2@gamil.com")
                    .gender(Gender.MALE)
                    .address(address)
                    .favouriteSubjects(List.of("자바", "스프링"))
                    .totalSpentInBooks(BigDecimal.TEN)
                    .localDateTime(LocalDateTime.now())
                    .build();

//            repository.save(student);

            repository.findByEmail("test2@gamil.com")
                    .ifPresentOrElse(findStudent -> {
                        System.out.println("Already exists  " + findStudent);
                    }, () -> {
                        System.out.println("Inserting student " + student);
                        repository.save(student);
                    });

        };

    }
}
