package com.odockodock.odockodock_server.domain;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;

@Builder
public record Library(
        String name,
        String address,
        String tel,
        String closed,
        String operatingTime,
        String latitude,
        String longitude
) {
    public static Library from(JsonNode node) {
        return Library.builder()
                .name(node.path("libName").asText())
                .address(node.path("address").asText())
                .tel(node.path("tel").asText())
                .closed(node.path("closed").asText())
                .operatingTime(node.path("operatingTime").asText())
                .latitude(node.path("latitude").asText())
                .longitude(node.path("longitude").asText())
                .build();
    }
}