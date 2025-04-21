package edu.com.foodapi.util.mapper;


import edu.com.foodapi.persistence.entity.Orderd;
import edu.com.foodapi.presentation.dto.OrderdReponseDTO;
import edu.com.foodapi.presentation.dto.OrderdRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface OrderdMapper {
    OrderdMapper INSTANCE = Mappers.getMapper(OrderdMapper.class);


    @Mapping(target = "items", source = "items") // No mapeamos items directamente, lo haremos manualmente
    Orderd toOrderd(OrderdRequestDTO orderdRequestDTO);


    @Mapping(target = "items", source = "items")
    OrderdReponseDTO toOrderdReponseDto (Orderd orderd);

}
