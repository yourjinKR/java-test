package org.example.selfmade.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 가중치 계산
public class MapExample3 {
    public static void main(String[] args) {
        // 물건들이 있고 texMap은 세금을 표현한다, products의 총 세금을 구하는 방법.


        Product product1 = new Product(1, "물건1");
        Product product2 = new Product(2, "물건2");
        Product product3 = new Product(3, "물건3");
        List<Product> products = List.of(product1, product2, product3);

        Map<Product, Long> texMap = new HashMap<>();
        texMap.put(product1, 100L);
        texMap.put(product3, 200L);

        long totalText = products.stream()
                .mapToLong(product -> texMap.getOrDefault(product, 0L))
                .sum();

        System.out.println(totalText);
    }


    public static class Product {
        public long id;
        public String name;

        public Product(long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
