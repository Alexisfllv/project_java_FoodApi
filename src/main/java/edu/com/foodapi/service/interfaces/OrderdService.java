package edu.com.foodapi.service.interfaces;


import edu.com.foodapi.presentation.dto.OrderdReponseDTO;
import edu.com.foodapi.presentation.dto.OrderdRequestDTO;

import java.util.List;

public interface OrderdService {

    OrderdReponseDTO getOrderdReponseById(Long id);
    List<OrderdReponseDTO> findAllOrderd();
    OrderdReponseDTO save(OrderdRequestDTO orderdRequestDTO);
}
