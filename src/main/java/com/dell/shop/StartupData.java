package com.dell.shop;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dell.shop.product.Product;
import com.dell.shop.product.ProductService;
import com.dell.shop.user.User;
import com.dell.shop.user.UserService;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public StartupData(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setFirstName("Luis");
        user.setLastName("Alimari");
        user.setCity("Porto Alegre");
        user.setPasswordConfirm("user");
        user.setGender("Male");
        user.setEmail("luis_alimari@dell.com");
        user.setAge(42);

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();
        
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setCity("Eldorado do Sul");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@dell.com");

        userService.save(admin);
    }

    private void exampleProducts(){
        final String NAME = "Nike Shox";
        final String IMAGE_URL = "https://images.lojanike.com.br/500x500/produto/258823_2254941_20200630163934.png";
        final String DESCRIPTION = "Example Description";
        final BigDecimal PRICE = BigDecimal.valueOf(22);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName("Nike Shox");
        product1.setImageUrl("https://images.lojanike.com.br/500x500/produto/258823_2254941_20200630163934.png");
        product1.setDescription(DESCRIPTION);
        product1.setPrice(PRICE);

        product2.setName("Adidas ZX");
        product2.setImageUrl("https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/39c94fab9aa4447f812dabf900a26eaf_9366/Tenis_ZX_2K_Boost_Preto_FV9997_01_standard.jpg");
        product2.setDescription(DESCRIPTION);
        product2.setPrice(PRICE);

        product3.setName("Asics Resolution 8 Tokyo");
        product3.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTa0p-GqEOtMJF8dWjiIN2BEqZh_w5qKWFLo8uTIO-HTPfBugY&usqp=CAc");
        product3.setDescription(DESCRIPTION);
        product3.setPrice(PRICE);

        product4.setName("New Balance ML 501");
        product4.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSd4nzi0BPYh3VRK8HSUxOA9gE3n1ydLMWFKrrxqOCWPmrH1Jk&usqp=CAc");
        product4.setDescription(DESCRIPTION);
        product4.setPrice(PRICE);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
