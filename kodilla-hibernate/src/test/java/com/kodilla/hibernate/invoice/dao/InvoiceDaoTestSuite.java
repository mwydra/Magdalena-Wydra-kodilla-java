package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    private static final String NUMBER = "FV/2018/04/01";

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("Mysz komputerowa");
        Product product2= new Product("Dysk komputerowy");
        Product product3 = new Product("Pamięć RAM");
        Item item1 = new Item(new BigDecimal(5), 3, new BigDecimal(15));
        Item item2 = new Item(new BigDecimal(200), 1, new BigDecimal(200));
        Item item3 = new Item(new BigDecimal(100), 2, new BigDecimal(200));
        Invoice invoice = new Invoice(NUMBER);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertEquals("FV/2018/04/01", invoice.getNumber());
        List<Item> items = invoice.getItems();
        Assert.assertEquals(3, items.size());
        for (Item item : items) {
            System.out.println(item.getProduct().getName());
        }

        //CleanUp
        invoiceDao.delete(id);
    }
}
