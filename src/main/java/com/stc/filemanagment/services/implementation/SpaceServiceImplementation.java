package com.stc.filemanagment.services.implementation;

import com.stc.filemanagment.utils.Utilis;
import com.stc.filemanagment.dtos.ItemDto;
import com.stc.filemanagment.enums.PermissionLevel;
import com.stc.filemanagment.models.PermissionGroup;
import com.stc.filemanagment.models.Space;
import com.stc.filemanagment.repositories.SpaceRepository;
import com.stc.filemanagment.requests.SpaceRequest;
import com.stc.filemanagment.services.PermissionGroupService;
import com.stc.filemanagment.services.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SpaceServiceImplementation implements SpaceService {

    private final SpaceRepository spaceRepository;
    private final PermissionGroupService permissionGroupService;

    @Override
    @Transactional
    public ItemDto createSpace(SpaceRequest spaceRequest) {
        Space space = spaceRepository.save((Space) Space.builder().name(spaceRequest.getSpaceName()).build());
        PermissionGroup permissionGroup =
                createAndAssignPermissionGroup(spaceRequest.getUserEmailView(), spaceRequest.getUserEmailEdit());
        space.setPermissionGroup(permissionGroup);
        spaceRepository.save(space);
        return Utilis.mapToItemDto(space);
    }

    @Override
    public List<ItemDto> getAllSpaces() {
        return spaceRepository.findAll().stream().map(Utilis::mapToItemDto).collect(Collectors.toList());
    }

    @Override
    public ItemDto getSpaceById(UUID id) {
        Space space = spaceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Space not fount with id: " + id));
        return Utilis.mapToItemDto(space);
    }


    @Override
    public Space findSpaceById(UUID spaceId) {
        return spaceRepository.findById(spaceId)
                .orElseThrow(() -> new EntityNotFoundException("Space not fount with id: " + spaceId));
    }


    @Override
    @Transactional(readOnly = true)
    public void checkSpaceUserPermission(Space space, String userEmail, PermissionLevel permissionLevel)
            throws AccessDeniedException {
        Integer permissionExistCount =
                spaceRepository.checkSpaceUserPermission(space.getId(), userEmail, permissionLevel.name());
        if (permissionExistCount == 0) {
            throw new AccessDeniedException("insufficient permissions");
        }
    }

    private PermissionGroup createAndAssignPermissionGroup(String userEmailView, String userEmailEdit) {
        return permissionGroupService.createSpaceAdminGroupWithUsers(userEmailView, userEmailEdit);
    }
}
