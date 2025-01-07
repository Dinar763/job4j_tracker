package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
            .filter(product -> (product.getStandard() - product.getActual()) >= 0)
            .filter(product -> (product.getStandard() - product.getActual()) <= 3)
            .map(value -> new Label(value.getName(), value.getPrice() * 0.5f).toString())
            .collect(Collectors.toList());
    }
}
