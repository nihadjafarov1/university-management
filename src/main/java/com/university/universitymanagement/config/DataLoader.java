package com.university.universitymanagement.config;

import com.university.universitymanagement.entity.Role;
import com.university.universitymanagement.enums.UserRole;
import com.university.universitymanagement.repository.auth.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(UserRole.ROLE_STUDENT));
                roleRepository.save(new Role(UserRole.ROLE_ADMIN));
                roleRepository.save(new Role(UserRole.ROLE_TEACHER));
                roleRepository.save(new Role(UserRole.ROLE_TECHNICIAN));
            }
        };
    }
}