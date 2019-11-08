package service;

import model.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Products> products;

    static {
        products = new HashMap<>();
        products.put(1, new Products(1 , "Sam sung" , 10 , "Korea" , "Galaxy"));
        products.put(2, new Products(2 , "Iphone" , 20 , "United State" , "Ip7 plus"));
        products.put(3, new Products(3 , "Nokia" , 1 , "Korea" , "110i"));
        products.put(4, new Products(1 , "Black Berry" , 10 , "Canada" , "BB"));
        products.put(5, new Products(1 , "Sonny" , 15 , "Japan" , "Eriction"));
        products.put(6, new Products(1 , "Motorola" , 10 , "Unknow" , "Unknow"));
    }

    @Override
    public List<Products> fillAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Products product) {
        products.put(product.getId(),product);
    }

    @Override
    public Products findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Products product) {
        products.put(id , product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
