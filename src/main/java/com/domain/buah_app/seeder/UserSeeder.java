package com.domain.buah_app.seeder;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.domain.buah_app.models.User;
import com.domain.buah_app.repository.UserRepository;

@Component
public class UserSeeder implements CommandLineRunner {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserSeeder(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();

    User user1 = new User("muhammad@example.com", passwordEncoder.encode("Password1234"));
    User user2 = new User("naufan@example.com", passwordEncoder.encode("Password1234"));

    userRepository.saveAll(List.of(user1, user2));

    System.out.println("User data seeded!");
  }
}
