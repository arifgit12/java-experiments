package com.app.collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {
    static List<Product> productList = Stream.of(
            new Product("Mobile", 9500,"Samsung", "Electronics"),
            new Product("Keyboard", 9500,"Apple", "Electronics"),
            new Product("Books", 250,"It End with Us", "Education"),
            new Product("Remote Control Toys", 699,"Webley High Speed", "Toys")
    ).collect(Collectors.toList());

    public static List<Product> getProducts(){
        return productList;
    }


}
