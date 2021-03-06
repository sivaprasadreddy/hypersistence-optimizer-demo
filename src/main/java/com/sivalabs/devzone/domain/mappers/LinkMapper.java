package com.sivalabs.devzone.domain.mappers;

import com.sivalabs.devzone.domain.entities.Link;
import com.sivalabs.devzone.domain.entities.Tag;
import com.sivalabs.devzone.domain.models.LinkDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LinkMapper {

    public LinkDTO toDTO(Link link) {
        LinkDTO dto = new LinkDTO();
        dto.setId(link.getId());
        dto.setUrl(link.getUrl());
        dto.setTitle(link.getTitle());
        dto.setCreatedUserId(link.getCreatedBy().getId());
        dto.setCreatedUserName(link.getCreatedBy().getName());
        dto.setCreatedAt(link.getCreatedAt());
        dto.setUpdatedAt(link.getUpdatedAt());
        if (link.getTags() != null) {
            dto.setTags(link.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
        }
        return dto;
    }

}
