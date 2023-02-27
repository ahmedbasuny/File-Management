package com.stc.filemanagment.services.implementation;


import com.stc.filemanagment.utils.Utilis;
import com.stc.filemanagment.enums.PermissionLevel;
import com.stc.filemanagment.models.Folder;
import com.stc.filemanagment.models.Space;
import com.stc.filemanagment.repositories.FolderRepository;
import com.stc.filemanagment.requests.FolderRequest;
import com.stc.filemanagment.services.FolderService;
import com.stc.filemanagment.services.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class FolderServiceImplementation implements FolderService {

    private final SpaceService spaceService;
    private final FolderRepository folderRepository;

    @Override
    public Object createFolder(UUID spaceId, FolderRequest folderRequest) throws AccessDeniedException {
        Space space = spaceService.findSpaceById(spaceId);
        spaceService.checkSpaceUserPermission(space, folderRequest.getUserEmail(), PermissionLevel.EDIT);
        Folder folder = Folder.builder().space(space).name(folderRequest.getFolderName()).build();
        return Utilis.mapToItemDto(folderRepository.save(folder));
    }

    @Override
    public Folder findFolderById(UUID id) {
        return folderRepository.findById(id).orElseThrow( () ->
                new EntityNotFoundException("Folder not found with id: " + id));
    }


}
