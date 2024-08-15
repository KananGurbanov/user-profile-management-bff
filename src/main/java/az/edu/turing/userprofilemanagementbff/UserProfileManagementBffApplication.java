package az.edu.turing.userprofilemanagementbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })
public class UserProfileManagementBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileManagementBffApplication.class, args);
	}

}
