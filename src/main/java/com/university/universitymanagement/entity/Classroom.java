package com.university.universitymanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "classrooms")
public class Classroom extends BaseEntity {
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "capacity")
    Integer capacity;
    @Column(name = "floor")
    Integer floor;
    @Column(name = "has_projector ")
    Boolean hasProjector;
    @Column(name = "is_projector_working")
    Boolean isProjectorWorking;
    @Column(name = "has_blackboard")
    Boolean hasBlackboard;
    @Column(name = "is_blackboard_working")
    Boolean isBlackboardWorking;
    @Column(name = "has_smart_board")
    Boolean hasSmartBoard;
    @Column(name = "is_smart_board_working")
    Boolean isSmartBoardWorking;
    @Column(name = "type")
    String type;
}
