package com.stc.filemanagment.repositories;

import com.stc.filemanagment.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {
}
