package edu.com.foodapi.service.interfaces;


import edu.com.foodapi.presentation.dto.OrderdItemResponseDTO;

import java.util.List;

public interface OrderItemService {

    List<OrderdItemResponseDTO> listado();

    OrderdItemResponseDTO buscar(Long id);

}
