package edu.com.foodapi.util.mapper;


import edu.com.foodapi.persistence.entity.Orderd;
import edu.com.foodapi.presentation.dto.OrderdReponseDTO;
import edu.com.foodapi.presentation.dto.OrderdRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderdMapper {



    Orderd toOrderd(OrderdRequestDTO orderdRequestDTO);

    OrderdReponseDTO toOrderdReponseDto (Orderd orderd);

}
