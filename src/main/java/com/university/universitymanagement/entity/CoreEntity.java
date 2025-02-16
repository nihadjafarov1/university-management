package com.university.universitymanagement.entity;

import com.university.universitymanagement.listener.CoreEntityListener;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(CoreEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class CoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id;
    @Column(name = "created_by", nullable = false)
    String createdBy;
    @Column(name = "created_date", nullable = false)
    Instant createdDate;
    @Column(name = "status", nullable = false)
    String status;
    @Column(name = "action_status")
    String actionStatus;
    @Column(name = "insert_date", nullable = false)
    Instant insertDate;
    @Column(name = "modified_date")
    Instant modifiedDate;
    @Column(name = "modified_by")
    String modifiedBy;
}
