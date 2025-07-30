package edu.com.foodapi.service.interfaces;


import edu.com.foodapi.presentation.dto.ProductRequestDTO;
import edu.com.foodapi.presentation.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    // listar
    List<ProductResponseDTO> listar();
    // buscar
    ProductResponseDTO buscarPorId(Long id);
    // registrar
    ProductResponseDTO salvar(ProductRequestDTO productRequestDTO);
    // modificar
    ProductResponseDTO alterar(ProductRequestDTO productRequestDTO , Long id);
    // eliminar
    void excluir(Long id);
}
