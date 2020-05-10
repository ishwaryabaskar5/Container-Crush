package com.containercrush.unbeatable.product.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*creates a document in mongo db */
@Document(collection = "DonorProfile")
@ApiModel(description = "Product POJO")
public class Product {
    @Id
    private int id;
    @NotNull
    private String name;
    private String description;
    private String unit;
    @NotNull
    private float unitPrice;
    @NotNull
    private boolean isAvailable;
}
