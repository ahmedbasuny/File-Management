package com.stc.filemanagment.services;

import com.stc.filemanagment.dtos.ItemDto;
import com.stc.filemanagment.enums.PermissionLevel;
import com.stc.filemanagment.models.Space;
import com.stc.filemanagment.requests.SpaceRequest;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

public interface SpaceService {
    ItemDto createSpace(SpaceRequest spaceRequest);

    Object getAllSpaces();

    Object getSpaceById(UUID id);

    void checkSpaceUserPermission(Space space, String userEmail, PermissionLevel edit) throws AccessDeniedException;

    Space findSpaceById(UUID spaceId);
}
