package com.stc.filemanagment.services.implementation;


import com.stc.filemanagment.utils.Utilis;
import com.stc.filemanagment.dtos.FileDto;
import com.stc.filemanagment.models.File;
import com.stc.filemanagment.models.FileData;
import com.stc.filemanagment.models.Folder;
import com.stc.filemanagment.repositories.FileDataRepository;
import com.stc.filemanagment.repositories.FileRepository;
import com.stc.filemanagment.services.FileService;
import com.stc.filemanagment.services.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class FileServiceImplementation implements FileService {

    private final FolderService folderService;
    private final FileDataRepository fileDataRepository;
    private final FileRepository fileRepository;

    @Override
    @Transactional
    public Object createFile(UUID folderId, MultipartFile file) throws IOException {
        Folder folder = folderService.findFolderById(folderId);
        FileData fileData = FileData.builder().data(file.getBytes()).build();
        fileDataRepository.save(fileData);
        File newFile = File.builder().fileData(fileData).folder(folder).name(file.getOriginalFilename()).build();
        fileRepository.save(newFile);
        return Utilis.mapToItemDto(newFile);
    }

    @Override
    public Object getFileMetaData(UUID fileId) {
        File file = fileRepository.findById(fileId).orElseThrow(() ->
                new EntityNotFoundException("File not found with id: " + fileId));
        return Utilis.mapToItemDto(file);
    }

    @Override
    public FileDto downloadFile(UUID fileId) {
        File file = fileRepository.findById(fileId).orElseThrow(() ->
                new EntityNotFoundException("File not found with id: " + fileId));
        FileData fileData = fileDataRepository.findById(file.getFileData().getId()).orElseThrow(() ->
                new EntityNotFoundException("File Data not found with id: " + file.getFileData().getId()));
        return FileDto.builder()
                .id(file.getId())
                .name(file.getName())
                .resource(new ByteArrayResource(fileData.getData()))
                .build();
    }
}
