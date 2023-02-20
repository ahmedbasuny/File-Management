package com.stc.filemanagment.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ItemDto {
    private UUID id;
    private String name;
}
