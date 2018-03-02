package com.kodilla.good.patterns.challenges;

public class CosmeticsOrderService implements OrderService{
    public boolean order(final Customer customer, final Product product){
        System.out.println("Zamówienie " + product.getName() + " " + product.getDescription() + " dla " + customer.getName() + " " + customer.getSurname() + " zostało przekazane do realizacji.");

        MailService mailService = new MailService();
        mailService.sendEmail(customer);

        CosmeticsOrderRepository cosmeticsOrderRepository = new CosmeticsOrderRepository();
        cosmeticsOrderRepository.createCosmeticOrder(customer, product);

        return true;
    }

}
