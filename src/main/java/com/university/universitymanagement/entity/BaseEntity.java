package com.university.universitymanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder
@Getter
@Setter
//@EntityListeners({CoreEntityListener.class})
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "created_date")
    Instant createdDate;
    @Column(name = "status")
    String status;
    @Column(name = "insert_date")
    Instant insertDate;
    @Column(name = "modification_date")
    Instant modificationDate;
    @Column(name = "modification_by")
    String modificationBy;
}