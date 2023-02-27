package com.stc.filemanagment.services;

import com.stc.filemanagment.dtos.FileDto;
import com.stc.filemanagment.requests.FolderRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.UUID;

public interface FileService {
    Object createFile(UUID folderId, MultipartFile file) throws IOException;

    Object getFileMetaData(UUID fileId);

    FileDto downloadFile(UUID fileId);
}
