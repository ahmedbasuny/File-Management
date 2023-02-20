package com.stc.filemanagment.controllers;

import com.stc.filemanagment.dtos.FileDto;
import com.stc.filemanagment.dtos.ItemDto;
import com.stc.filemanagment.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/folders/{folderId}/files")
    public ResponseEntity<ItemDto> createFile(@PathVariable UUID folderId, @RequestParam MultipartFile file)
            throws IOException {
        return new ResponseEntity(fileService.createFile(folderId, file), HttpStatus.ACCEPTED);
    }

    @GetMapping("/folders/files/{fileId}")
    public ResponseEntity<ItemDto> getFileMetaData(@PathVariable UUID fileId) {
        return new ResponseEntity(fileService.getFileMetaData(fileId), HttpStatus.OK);
    }

    @GetMapping("/folders/files/download/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable UUID fileId) {
        FileDto file = fileService.downloadFile(fileId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.getResource().contentLength())
                .body(file.getResource());
    }
}
