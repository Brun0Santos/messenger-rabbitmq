package io.github.bruno.consumerservice.dtos;

import java.io.Serial;
import java.io.Serializable;

public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 12L;
    private Integer id;
    private String name;
    private Double price;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
