package com.shop.cart.domain.adapter;

public interface Adapter<Entity, DTO> {

    Entity fromDTO(DTO dto);

    DTO fromEntity(Entity entity);
}
