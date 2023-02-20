package com.stc.filemanagment.repositories;

import com.stc.filemanagment.models.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileDataRepository extends JpaRepository<FileData, UUID> {
}
