package com.stc.filemanagment.controllers;

import com.stc.filemanagment.dtos.ItemDto;
import com.stc.filemanagment.requests.FolderRequest;
import com.stc.filemanagment.services.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/spaces/{spaceId}/folders")
    public ResponseEntity<ItemDto> createFolder(@PathVariable UUID spaceId, @RequestBody FolderRequest folderRequest)
            throws AccessDeniedException {
        return new ResponseEntity(folderService.createFolder(spaceId, folderRequest), HttpStatus.ACCEPTED);
    }
}
