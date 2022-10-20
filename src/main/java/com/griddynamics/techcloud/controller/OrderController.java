package com.griddynamics.techcloud.controller;

import com.griddynamics.techcloud.model.AssemblyOrder;
import com.griddynamics.techcloud.repo.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("assemblyOrder")
public class OrderController {
    @Autowired
    private OrderRepository repository;

    @GetMapping("/current")
    public String showOrderForm() {
        return "order";
    }

    @PostMapping
    public String processOrder(AssemblyOrder assemblyOrder,
                               SessionStatus sessionStatus) {
        log.info("Order complete: {}", assemblyOrder);
        repository.save(assemblyOrder);

        sessionStatus.setComplete();
        return "redirect:/";
    }
}
