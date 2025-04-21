package edu.com.foodapi.service.inplementation;


import edu.com.foodapi.persistence.entity.OrderItem;
import edu.com.foodapi.persistence.entity.Orderd;
import edu.com.foodapi.persistence.repository.OrderdItemRepository;
import edu.com.foodapi.persistence.repository.OrderdRepository;
import edu.com.foodapi.presentation.dto.OrderdReponseDTO;
import edu.com.foodapi.presentation.dto.OrderdRequestDTO;
import edu.com.foodapi.service.interfaces.OrderdService;
import edu.com.foodapi.util.mapper.OrderdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderdServiceImplementation implements OrderdService {

    private final OrderdRepository orderdRepository;
    private final OrderdMapper orderdMapper;

    private final OrderdItemRepository orderdItemRepository;

    @Override
    public OrderdReponseDTO getOrderdReponseById(Long id) {
        Orderd orderd = orderdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no encontrado :"+id));

        return orderdMapper.toOrderdReponseDto(orderd);
    }

    @Override
    public List<OrderdReponseDTO> findAllOrderd() {
        List<Orderd> orderds = orderdRepository.findAll();
        return orderds
                .stream()
                .map(orderdMapper::toOrderdReponseDto)
                .toList();
    }

    @Override
    public OrderdReponseDTO save(OrderdRequestDTO orderdRequestDTO) {
        Orderd orderd = orderdMapper.toOrderd(orderdRequestDTO);
        orderdRepository.save(orderd);
        return orderdMapper.toOrderdReponseDto(orderd);
    }
}
