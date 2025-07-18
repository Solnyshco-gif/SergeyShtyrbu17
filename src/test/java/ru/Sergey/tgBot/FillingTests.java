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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void fillTestData() {
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