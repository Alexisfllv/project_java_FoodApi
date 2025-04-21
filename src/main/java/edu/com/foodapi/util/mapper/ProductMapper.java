package edu.com.foodapi.util.mapper;


import edu.com.foodapi.persistence.entity.Products;
import edu.com.foodapi.presentation.dto.ProductRequestDTO;
import edu.com.foodapi.presentation.dto.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface ProductMapper {


    Products toProducts(ProductRequestDTO productRequestDTO);

    ProductResponseDTO toProductResponseDTO (Products products);


    // update set de Entity -> Request

    @Mapping(target = "id", ignore = true)
    void updateFromDto(ProductRequestDTO productRequestDTO, @MappingTarget Products products);

}
