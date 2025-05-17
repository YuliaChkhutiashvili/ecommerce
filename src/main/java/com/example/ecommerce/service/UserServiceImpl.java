package com.example.ecommerce.service;
import com.example.ecommerce.exception.NotEnoughBudgetException;
import com.example.ecommerce.exception.OutOfStockException;
import com.example.ecommerce.exception.UserNotFoundException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Map<String, User> userMap = new HashMap<>();
    private final ProductService productService;

    public UserServiceImpl(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public void registerUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public void orderProduct(String userId, String productName) {
        User user = getUser(userId);
        Product product = productService.getProduct(productName);
        if (product.getStock() <= 0) throw new OutOfStockException(productName);
        if (user.getBudget() < product.getPrice()) throw new NotEnoughBudgetException(user.getId());
        user.setBudget(user.getBudget() - product.getPrice());
        product.setStock(product.getStock() - 1);
        user.addOrder(product);
    }

    @Override
    public void orderAllFromCart(String userId) {
        throw new UnsupportedOperationException("Use CartService for cart-related operations");
    }

    @Override
    public void orderSelectedFromCart(String userId, List<String> selectedProductNames) {
        User user = getUser(userId);

        List<Product> selectedProducts = user.getCart().values().stream()
                .filter(p -> selectedProductNames.contains(p.getName()))
                .collect(Collectors.toList());

        for (Product p : selectedProducts) {
            if (p.getStock() <= 0) {
                throw new OutOfStockException(p.getName());
            }
            if (user.getBudget() < p.getPrice()) {
                throw new NotEnoughBudgetException(user.getId());
            }

            user.setBudget(user.getBudget() - p.getPrice());
            p.setStock(p.getStock() - 1);
            user.getOrders().put(p.getName(), p);  // Orders არის Map, ამიტომ აქ პირდაპირ ვადებთ
        }

        for (String productName : selectedProductNames) {
            user.getCart().remove(productName);
        }

    }
    @Override
    public List<Product> viewOrders(String userId) {
        User user = getUser(userId);
        return user.getOrdersList();
    }


    @Override
    public User getUser(String userId) {
        User user = userMap.get(userId);
        if (user == null) throw new UserNotFoundException(userId);
        return user;
    }


    @Override
    public List<Product> getAllAvailableProducts() {
        return List.of();
    }
}