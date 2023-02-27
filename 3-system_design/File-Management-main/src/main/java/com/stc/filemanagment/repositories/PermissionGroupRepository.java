package com.stc.filemanagment.repositories;

import com.stc.filemanagment.models.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, UUID> {
}
