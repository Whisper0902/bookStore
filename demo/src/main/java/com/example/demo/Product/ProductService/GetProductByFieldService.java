package com.example.demo.Product.ProductService;

import com.example.demo.Product.ProductEntity.ProductEntity;
import com.example.demo.Product.ProductRepository.ProductHomepage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GetProductByFieldService {


    @Autowired
    private ProductHomepage productHomepage;


    public List<ProductEntity> getProductByField(Map<String,Object> field)
    {
        List<ProductEntity> listProduct = new ArrayList<>();
        boolean isValidKey = false;
        for(Map.Entry<String,Object> entry : field.entrySet())
        {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key){
                case "genre":
                    String genre = (String) value;
                    listProduct = productHomepage.findAllByGenre(genre);
                    isValidKey= true;
                    break;
                case "author":
                    String author = (String) value;
                    listProduct = productHomepage.findAllByAuthor(author);
                    isValidKey= true;
                    break;
                case "publisher":
                    String publisher = (String) value;
                    listProduct = productHomepage.findAllByPublisher(publisher);
                    isValidKey= true;
                    break;

            }
        }

        if (!isValidKey) {
            throw new IllegalArgumentException("not found key valid in field");
        }
        return listProduct;

    }
}
