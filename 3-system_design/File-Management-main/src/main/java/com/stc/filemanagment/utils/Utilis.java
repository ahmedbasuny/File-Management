package com.stc.filemanagment.utils;

import com.stc.filemanagment.dtos.ItemDto;
import com.stc.filemanagment.models.Item;

public class Utilis {

    public static ItemDto mapToItemDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .build();
    }
}
