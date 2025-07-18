<<<<<<< HEAD
package ru.SergeyShtyrbu.tgBot;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.SergeyShtyrbu.tgBot.entity.Category;
import ru.SergeyShtyrbu.tgBot.entity.Product;
import ru.SergeyShtyrbu.tgBot.repository.CategoryRepository;
import ru.SergeyShtyrbu.tgBot.repository.ProductRepository;

@SpringBootTest
public class FillingTests {
=======
package ru.Sergey.tgBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.Sergey.tgBot.entity.Category;
import ru.Sergey.tgBot.entity.Product;
import ru.Sergey.tgBot.repository.CategoryRepository;
import ru.Sergey.tgBot.repository.ProductRepository;

import static org.testng.Assert.assertNotNull;

@SpringBootTest(classes = TgBotApplication.class)
public class FillingTests extends AbstractTestNGSpringContextTests {
>>>>>>> d424ca41628aaf969c27e9150296c39fdb37917c

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void fillTestData() {
<<<<<<< HEAD
        Category pizza = new Category();
        pizza.setName("Пицца");
        categoryRepository.save(pizza);

        Category rolls = new Category();
        rolls.setName("Роллы");
        categoryRepository.save(rolls);

        Category burgers = new Category();
        burgers.setName("Бургеры");
        categoryRepository.save(burgers);

        Category drinks = new Category();
        drinks.setName("Напитки");
        categoryRepository.save(drinks);

        // Подкатегории Роллы
        Category classicRolls = new Category();
        classicRolls.setName("Классические роллы");
        classicRolls.setParent(rolls);
        categoryRepository.save(classicRolls);

        Category bakedRolls = new Category();
        bakedRolls.setName("Запеченные роллы");
        bakedRolls.setParent(rolls);
        categoryRepository.save(bakedRolls);

        Category sweetRolls = new Category();
        sweetRolls.setName("Сладкие роллы");
        sweetRolls.setParent(rolls);
        categoryRepository.save(sweetRolls);

        Category rollSets = new Category();
        rollSets.setName("Наборы");
        rollSets.setParent(rolls);
        categoryRepository.save(rollSets);
        
        Product p1 = new Product();
        p1.setName("Ролл Филадельфия");
        p1.setDescription("Лосось, сыр, огурец");
        p1.setPrice(390.0);
        p1.setCategory(classicRolls);
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setName("Ролл Калифорния");
        p2.setDescription("Краб, авокадо");
        p2.setPrice(340.0);
        p2.setCategory(classicRolls);
        productRepository.save(p2);

        Product p3 = new Product();
        p3.setName("Ролл Осака");
        p3.setDescription("Тунец, сыр, огурец");
        p3.setPrice(370.0);
        p3.setCategory(classicRolls);
        productRepository.save(p3);
    }
}
=======
        // Создаем основные категории
        Category pizza = createAndSaveCategory("Пицца", null);
        Category rolls = createAndSaveCategory("Роллы", null);
        Category burgers = createAndSaveCategory("Бургеры", null);
        Category drinks = createAndSaveCategory("Напитки", null);

        // Создаем подкатегории для роллов
        Category classicRolls = createAndSaveCategory("Классические роллы", rolls);
        Category bakedRolls = createAndSaveCategory("Запеченные роллы", rolls);
        Category sweetRolls = createAndSaveCategory("Сладкие роллы", rolls);
        Category rollSets = createAndSaveCategory("Наборы", rolls);

        // Создаем продукты
        createAndSaveProduct("Ролл Филадельфия", "Лосось, сыр, огурец", 390.0, classicRolls);
        createAndSaveProduct("Ролл Калифорния", "Краб, авокадо", 340.0, classicRolls);
        createAndSaveProduct("Ролл Осака", "Тунец, сыр, огурец", 370.0, classicRolls);

        // Проверяем, что данные сохранились
        assertNotNull(categoryRepository.findAll());
        assertNotNull(productRepository.findAll());
    }

    private Category createAndSaveCategory(String name, Category parent) {
        Category category = new Category();
        category.setName(name);
        category.setParent(parent);
        return categoryRepository.save(category);
    }

    private void createAndSaveProduct(String name, String description, double price, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        productRepository.save(product);
    }
}
>>>>>>> d424ca41628aaf969c27e9150296c39fdb37917c
