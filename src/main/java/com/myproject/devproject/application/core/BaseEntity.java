package com.myproject.devproject.application.core;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class BaseEntity {

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @Column(name = "deleted_by")
    LocalDateTime deletedAt;
}
