package edu.com.foodapi.util.mapper;


import edu.com.foodapi.persistence.entity.OrderItem;
import edu.com.foodapi.persistence.entity.Orderd;
import edu.com.foodapi.presentation.dto.OrderdItemResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface OrderItemMapper {


    @Mapping(target = "orderdId", source = "orderd.id")
    OrderdItemResponseDTO toOrderdItemResponseDTO(OrderItem orderItem);
}
