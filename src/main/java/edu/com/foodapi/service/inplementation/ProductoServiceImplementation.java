package edu.com.foodapi.service.inplementation;


import edu.com.foodapi.persistence.entity.Products;
import edu.com.foodapi.persistence.repository.ProductRepository;
import edu.com.foodapi.presentation.dto.ProductRequestDTO;
import edu.com.foodapi.presentation.dto.ProductResponseDTO;
import edu.com.foodapi.service.interfaces.ProductService;
import edu.com.foodapi.util.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImplementation implements ProductService {

    //
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public List<ProductResponseDTO> listar() {
        List<Products> products = productRepository.findAll();
        return products.stream()
                .map(product -> productMapper.toProductResponseDTO(product))
                .toList();
    }

    @Override
    public ProductResponseDTO buscarPorId(Long id) {
        Products product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado : "+id));
        return productMapper.toProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO salvar(ProductRequestDTO productRequestDTO) {
        Products product = productMapper.toProducts(productRequestDTO);
        productRepository.save(product);
        return productMapper.toProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO alterar(ProductRequestDTO productRequestDTO, Long id) {
        Products existProduct = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado : "+id));

        //
        productMapper.updateFromDto(productRequestDTO, existProduct);

        productRepository.save(existProduct);
        return productMapper.toProductResponseDTO(existProduct);
    }

    @Override
    public void excluir(Long id) {
        Products idExiste =  productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado : "+id));

        productRepository.deleteById(id);
    }
}
