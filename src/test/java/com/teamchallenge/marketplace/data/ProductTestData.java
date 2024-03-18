package com.teamchallenge.marketplace.data;

import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.dto.product.ProductDetailTo;
import com.teamchallenge.marketplace.entity.product.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class ProductTestData {
    public static ProductDetailTo getProductDetailTo() {
        return new ProductDetailTo(4, null, UserTestData.getUserBriefTo(), "Золотий браслет",
                15, 1200, "Золотий браслет", getCategories(), 5.0f);
    }

    private static List<ProductCategory> getCategories() {
        ProductCategory jewelry = new ProductCategory("Jewelry");
        jewelry.setId(7);

        ProductCategory present = new ProductCategory("Present");
        present.setId(8);

        return List.of(jewelry, present);
    }

    public static List<ProductBriefTo> getPresentsAndEmbroidery(int pageNumber, int pageSize) {
        ProductBriefTo p1 = new ProductBriefTo(1, null, "Смішна футболка", 600, true);
        ProductBriefTo p2 = new ProductBriefTo(2, null, "Смішна кружка", 280, true);
        ProductBriefTo p3 = new ProductBriefTo(3, null, "Діамантове кольє", 1500, true);
        ProductBriefTo p4 = new ProductBriefTo(4, null, "Золотий браслет", 1200, true);
        ProductBriefTo p5 = new ProductBriefTo(5, null, "Вишивана подушка", 1000, true);
        ProductBriefTo p6 = new ProductBriefTo(6, null, "Вишиваний рушник", 550, true);
        ProductBriefTo p9 = new ProductBriefTo(9, null, "Смішна шапка", 150, true);
        ProductBriefTo p10 = new ProductBriefTo(10, null, "Вишивана сукня", 800, true);

        List<ProductBriefTo> briefTos = List.of(p1, p2, p3, p4, p5, p6, p9, p10);
        List<ProductBriefTo> result = new ArrayList<>(pageSize);

        int startNumber = pageNumber * pageSize;
        int endNumber = startNumber + pageSize - 1;
        for (int i = startNumber; i < briefTos.size() && i <= endNumber; i++) {
            result.add(briefTos.get(i));
        }

        return result;
    }
}
