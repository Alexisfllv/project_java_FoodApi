package edu.com.foodapi.util.mapper;


import edu.com.foodapi.persistence.entity.OrderItem;
import edu.com.foodapi.persistence.entity.Orderd;
import edu.com.foodapi.presentation.dto.OrderdItemResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);


    OrderdItemResponseDTO toOrderdItemResponseDTO(OrderItem orderItem);

}
