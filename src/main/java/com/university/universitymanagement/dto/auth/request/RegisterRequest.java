package com.university.universitymanagement.dto.auth.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class RegisterRequest {
    String username;
    String password;
}
