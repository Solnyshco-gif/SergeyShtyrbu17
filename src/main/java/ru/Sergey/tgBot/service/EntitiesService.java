package ru.Sergey.tgBot.service;

import ru.Sergey.tgBot.entity.Client;
import ru.Sergey.tgBot.entity.ClientOrder;
import ru.Sergey.tgBot.entity.Product;

import java.util.List;

public interface EntitiesService {
    List<Product> getProductsByCategoryId(Long categoryId);

    List<ClientOrder> getClientOrders(Long clientId);

    List<Product> getClientProducts(Long clientId);

    List<Product> getTopPopularProducts(Integer limit);

    List<Client> searchClientsByName(String name);

    List<Product> searchProducts(String name, Long categoryId);
}
