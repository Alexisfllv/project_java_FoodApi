package edu.com.foodapi.service.inplementation;


import edu.com.foodapi.persistence.entity.OrderItem;
import edu.com.foodapi.persistence.entity.Orderd;
import edu.com.foodapi.persistence.entity.Products;
import edu.com.foodapi.persistence.repository.OrderdItemRepository;
import edu.com.foodapi.persistence.repository.OrderdRepository;
import edu.com.foodapi.persistence.repository.ProductRepository;
import edu.com.foodapi.presentation.dto.OrderdReponseDTO;
import edu.com.foodapi.presentation.dto.OrderdRequestDTO;
import edu.com.foodapi.service.interfaces.OrderdService;
import edu.com.foodapi.util.mapper.OrderdMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderdServiceImplementation implements OrderdService {

    private final OrderdRepository orderdRepository;
    private final OrderdMapper orderdMapper;

    private final OrderdItemRepository orderdItemRepository;
    private final ProductRepository productRepository;

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

    @Transactional
    @Override
    public OrderdReponseDTO save(OrderdRequestDTO orderdRequestDTO) {
        Orderd orderd =  new Orderd();

        orderd.setOrderNo(orderdRequestDTO.orderNo());
        orderd.setCreateTime(LocalDateTime.now());

        List<OrderItem> items = orderdRequestDTO.items()
                .stream()
                .map(orderdItemRequestDTO -> {
                    Products product = productRepository.findById(orderdItemRequestDTO.idproducto())
                            .orElseThrow(() -> new RuntimeException("producto no encontrado :"+orderdItemRequestDTO.idproducto()));

                    // calculo de
                    BigDecimal total =  product.getProductPrice()
                            .multiply(new BigDecimal(orderdItemRequestDTO.itemQuantity()));

                    log.warn("id oderd "+ orderd.getId());
                    return new OrderItem(null, product,orderdItemRequestDTO.itemQuantity(), total,orderd);

                }).toList();

        // sumar los precios de itemtotal
        BigDecimal totalOrderPrice = items.
                stream()
                        .map(orderItem -> orderItem.getItemTotalPrice())
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

        orderd.setTotalPrice(totalOrderPrice);

        orderd.setItems(items);
        // Guardar la orden completa (orden + items por Cascade.ALL)
        Orderd savedOrder = orderdRepository.save(orderd);

        // Log post guardado con ID generado
        log.info("Orden guardada con ID: " + savedOrder.getId());

        // Devolver DTO de respuesta
        return orderdMapper.toOrderdReponseDto(savedOrder);
    }
}
