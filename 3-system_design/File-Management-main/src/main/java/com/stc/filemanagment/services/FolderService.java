package com.stc.filemanagment.services;

import com.stc.filemanagment.models.Folder;
import com.stc.filemanagment.requests.FolderRequest;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

public interface FolderService {
    Object createFolder(UUID spaceId, FolderRequest folderRequest) throws AccessDeniedException;
    Folder findFolderById(UUID id);
}
