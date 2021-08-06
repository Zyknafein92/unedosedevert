package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public static Product toProduit(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .title(productDTO.getTitle())
                .brand(productDTO.getBrand())
                .origin(productDTO.getOrigin())
                .productDescription(productDTO.getProductDescription())
                .utilisationAdvice(productDTO.getUtilisationAdvice())
                .composition(productDTO.getComposition())
                .whyThisProduct(productDTO.getWhyThisProduct())
                .producer(productDTO.getProducer())
                .producerComment(productDTO.getProducerComment())
                .allergen(productDTO.getAllergen())
                .nutritionalInformation(productDTO.getNutritionalInformation())
                .additionalInformation(productDTO.getAdditionalInformation())
                .urlPicture1(productDTO.getUrlPicture1())
                .urlPicture2(productDTO.getUrlPicture2())
                .urlPicture3(productDTO.getUrlPicture3())
                .build();
    }

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .brand(product.getBrand())
                .origin(product.getOrigin())
                .productDescription(product.getProductDescription())
                .utilisationAdvice(product.getUtilisationAdvice())
                .composition(product.getComposition())
                .whyThisProduct(product.getWhyThisProduct())
                .producer(product.getProducer())
                .producerComment(product.getProducerComment())
                .allergen(product.getAllergen())
                .nutritionalInformation(product.getNutritionalInformation())
                .additionalInformation(product.getAdditionalInformation())
                .urlPicture1(product.getUrlPicture1())
                .urlPicture2(product.getUrlPicture2())
                .urlPicture3(product.getUrlPicture3())
                .build();
    }

    public static ProductDTO toCompleteDTO(Product product) {
        TypeDTO typeDTO = TypeDTO.builder()
                .id(product.getType().getId())
                .name(product.getType().getName())
                .build();

        CategorieDTO categorieDTO = CategorieDTO.builder()
                .id(product.getCategorie().getId())
                .name(product.getCategorie().getName())
                .build();

        SubCategorieDTO subCategorieDTO = SubCategorieDTO.builder()
                .id(product.getSubCategorie().getId())
                .name(product.getSubCategorie().getName())
                .build();

        List<TagDTO> tagDTOList = product.getTags().stream().map(TagMapper::toDTO).collect(Collectors.toList());

        List<LabelDTO> labelDTOList = product.getLabels().stream().map(LabelMapper::toDTO).collect(Collectors.toList());

        List<VariantDTO> variantDTOList = product.getVariants().stream().map(VariantMapper::toDTO).collect(Collectors.toList());

        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .brand(product.getBrand())
                .origin(product.getOrigin())
                .productDescription(product.getProductDescription())
                .utilisationAdvice(product.getUtilisationAdvice())
                .composition(product.getComposition())
                .whyThisProduct(product.getWhyThisProduct())
                .producer(product.getProducer())
                .producerComment(product.getProducerComment())
                .allergen(product.getAllergen())
                .nutritionalInformation(product.getNutritionalInformation())
                .additionalInformation(product.getAdditionalInformation())
                .urlPicture1(product.getUrlPicture1())
                .urlPicture2(product.getUrlPicture2())
                .urlPicture3(product.getUrlPicture3())
                .type(typeDTO)
                .categorie(categorieDTO)
                .subCategorie(subCategorieDTO)
                .tags(tagDTOList)
                .labels(labelDTOList)
                .variants(variantDTOList)
                .build();
    }

    public static void update(ProductDTO dto, Product entity) {
        entity.setTitle(dto.getTitle());
        entity.setBrand(dto.getBrand());
        entity.setOrigin(dto.getOrigin());
        entity.setProductDescription(dto.getProductDescription());
        entity.setUtilisationAdvice(dto.getUtilisationAdvice());
        entity.setComposition(dto.getComposition());
        entity.setWhyThisProduct(dto.getWhyThisProduct());
        entity.setProducer(dto.getProducer());
        entity.setProducer(dto.getProducerComment());
        entity.setAllergen(dto.getAllergen());
        entity.setNutritionalInformation(dto.getNutritionalInformation());
        entity.setAdditionalInformation(dto.getAdditionalInformation());
        entity.setUrlPicture1(dto.getUrlPicture1());
        entity.setUrlPicture2(dto.getUrlPicture2());
        entity.setUrlPicture3(dto.getUrlPicture3());
    }
}

