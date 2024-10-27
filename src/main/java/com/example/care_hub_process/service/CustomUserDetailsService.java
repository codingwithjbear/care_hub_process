package com.example.care_hub_process.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.care_hub_process.dto.UserResponse;

import org.springframework.security.core.userdetails.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final RestTemplate restTemplate;

    public CustomUserDetailsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String url = "http://localhost:8000/api/user/" + username;
        UserResponse userResponse = restTemplate.getForObject(url, UserResponse.class);

        if (userResponse == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Return a Spring Security User object with the hashed password
        return User.builder()
            .username(userResponse.getUsername())
            .password(userResponse.getPassword())  // This is the hashed password from Django
            .roles("USER")  // Assign roles as needed
            .build();
    }
}
