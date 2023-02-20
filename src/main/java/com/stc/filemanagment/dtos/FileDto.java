package com.stc.filemanagment.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.ByteArrayResource;

import java.util.UUID;

@Data
@Builder
public class FileDto {
    private UUID id;
    private String name;
    private ByteArrayResource resource;
}
