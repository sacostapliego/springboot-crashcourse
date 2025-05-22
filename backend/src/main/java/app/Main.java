package app;

// import s3.S3Buckets;
// import s3.S3Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import app.customer.CustomerRepository;

// import java.util.UUID;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        
    }

    @Bean
    CommandLineRunner runner(
            CustomerRepository customerRepository,
            PasswordEncoder passwordEncoder
            /* S3Service s3Service,
            S3Buckets s3Buckets */) {
        return args -> {
            // testBucketUploadAndDownload(s3Service, s3Buckets);
        };
    }

    /* 
    private void testBucketUploadAndDownload(S3Service s3Service, S3Buckets S3Buckets) {
        s3Service.putObject(
            S3Buckets.getCustomer(), 
            "foo/bar/jamila-" + UUID.randomUUID(), 
            "Hello World".getBytes()
        );

        byte[] obj = s3Service.getObject(
            S3Buckets.getCustomer(), 
            "foo/bar/jamila"
        );

        System.out.println("Hello: " + new String(obj));
    } 
    */
}
