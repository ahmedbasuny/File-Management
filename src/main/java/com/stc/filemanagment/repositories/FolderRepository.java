package com.stc.filemanagment.repositories;

import com.stc.filemanagment.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FolderRepository extends JpaRepository<Folder, UUID> {
}
