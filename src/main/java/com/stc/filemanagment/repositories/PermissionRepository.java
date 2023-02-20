package com.stc.filemanagment.repositories;

import com.stc.filemanagment.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
}
