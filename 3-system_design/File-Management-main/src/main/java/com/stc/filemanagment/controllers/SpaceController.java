package com.stc.filemanagment.controllers;

import com.stc.filemanagment.dtos.ItemDto;
import com.stc.filemanagment.requests.SpaceRequest;
import com.stc.filemanagment.services.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @PostMapping("/spaces")
    public ResponseEntity<ItemDto> createSpace(@RequestBody SpaceRequest spaceRequest) {
        return new ResponseEntity(spaceService.createSpace(spaceRequest), HttpStatus.ACCEPTED);
    }

    @GetMapping("/spaces")
    public ResponseEntity<List<ItemDto>> getAllSpaces() {
        return new ResponseEntity(spaceService.getAllSpaces(), HttpStatus.OK);
    }

    @GetMapping("/spaces/{id}")
    public ResponseEntity<ItemDto> getSpaceById(@PathVariable UUID id) {
        return new ResponseEntity(spaceService.getSpaceById(id), HttpStatus.OK);
    }
}
