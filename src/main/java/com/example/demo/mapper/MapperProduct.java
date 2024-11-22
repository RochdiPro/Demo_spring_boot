package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class MapperProduct {
    public static Product map (ProductDto produit) {
        return new Product(  produit.getId(), produit.getName(), produit.getPrice(), produit.getCodeBarre(), produit.getDetail());
    }

    public static ProductDto map (Product produit) {
        return new ProductDto( produit.getId(), produit.getName(), produit.getPrice(), produit.getCodeBarre(), produit.getDetail());
    }

    public static List<ProductDto> mapProduitsToPRoduitDtos(List<Product> produits)
    {
        return produits.stream().map(MapperProduct::map).collect(Collectors.toList());

    }
    public static List<Product> mapDtosToProduits(List<ProductDto> produits)
    {
        return produits.stream().map(MapperProduct::map).collect(Collectors.toList());
    }

}
