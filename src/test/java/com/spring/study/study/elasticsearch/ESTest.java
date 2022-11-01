package com.spring.study.study.elasticsearch;

import com.spring.study.elasticsearch.dao.ProductDao;
import com.spring.study.elasticsearch.entity.Product;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qi
 * @description
 * @date 2022/8/22 16:46
 */
@SpringBootTest
public class ESTest {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    ProductDao productDao;

    @Test
    public void createIndex(){
        System.out.println("创建索引成功");
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    public void deleteIndex() throws IOException {
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices()
                .delete(new DeleteIndexRequest("product"), RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse.toString());
    }

    /**
     * 保存数据
     */
    @Test
    public void saveDocument(){
        Product product = new Product();
        product.setId(1001L);
        product.setName("小米手机");
        product.setPrice(1999.00);
        product.setImages("C:");
        productDao.save(product);
    }

    @Test
    public void updateDocument(){
        Product product = new Product();
        product.setId(1002L);
        product.setName("小米手机");
        product.setPrice(2999.00);
        product.setImages("C:");
        productDao.save(product);
    }

    @Test
    public void findById(){
        Product product = productDao.findById(1002L).get();
        System.out.println(product.getPrice());
    }

    @Test
    public void findProduct(){
        Iterable<Product> products = productDao.findAll();
        for (Product p: products) {
            System.out.println(p.getPrice());
        }
    }

    @Test
    public void batchSave(){
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(1003L + i);
            product.setName("小米手机" + i);
            product.setPrice(2999.00 + i);
            product.setImages("C:");
            list.add(product);
        }
        Iterable<Product> products = productDao.saveAll(list);
    }

    @Test
    public void delete(){
        Product product = new Product();
        product.setId(1002L);
        productDao.delete(product);
    }

    public void searchProduct(){

    }
}
