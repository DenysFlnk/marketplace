package com.teamchallenge.marketplace.service;

import com.teamchallenge.marketplace.dto.user.RegistrationTo;
import com.teamchallenge.marketplace.entity.order.Order;
import com.teamchallenge.marketplace.entity.user.User;
import com.teamchallenge.marketplace.entity.user.UserRole;
import com.teamchallenge.marketplace.repository.order.OrderRepository;
import com.teamchallenge.marketplace.repository.user.UserRepository;
import com.teamchallenge.marketplace.repository.user.UserRoleRepository;
import com.teamchallenge.marketplace.util.user.UserUtil;
import com.teamchallenge.marketplace.validation.RoleValidation;
import com.teamchallenge.marketplace.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserRepository userRepository;

    private OrderRepository orderRepository;

    private UserRoleRepository roleRepository;

    private Validator validator;

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getWithHistory(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Order> orders = orderRepository.getAllWithProductByUserId(id);

        user.setOrderHistory(orders);

        return user;
    }

    public User getWithFavorites(int id) {
        return userRepository.getWithFavorites(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(RegistrationTo form) {
        List<UserRole> allRoles = roleRepository.findAll();
        validator.validate(new RoleValidation(allRoles, form.getRoles()));

        UserUtil.setRoleIdsToForm(allRoles, form);

        User user = UserUtil.getUser(form);
        return userRepository.save(user);
    }
}
