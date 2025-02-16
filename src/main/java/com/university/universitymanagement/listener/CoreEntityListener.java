package com.university.universitymanagement.listener;

import com.university.universitymanagement.entity.CoreEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CoreEntityListener {

    @PrePersist
    private void preInsert(CoreEntity entity) {
        entity.setInsertDate(Instant.now());
        if (entity.getStatus() == null || entity.getStatus().isEmpty()) {
            entity.setStatus("A");
        }
        if (entity.getCreatedDate() == null) {
            entity.setCreatedDate(Instant.now());
        }
//        if (entity.createdBy == null) {
//            entity.setCreatedBy(manager.getCurrentUserId());
//        }
    }

    @PreUpdate
    private void preUpdate(CoreEntity entity) {
        entity.setModifiedDate(Instant.now());
//        entity.setModificationBy(manager.getCurrentUserId());
    }
}