package com.griddynamics.techcloud.controller;

import com.griddynamics.techcloud.converter.AssemblyToUDTConverter;
import com.griddynamics.techcloud.model.AssemblyOrder;
import com.griddynamics.techcloud.model.ComputerAssembly;
import com.griddynamics.techcloud.model.ComputerAssemblyUDT;
import com.griddynamics.techcloud.model.Constituent;
import com.griddynamics.techcloud.repo.AssemblyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

import static com.griddynamics.techcloud.utils.DataBase.getActualComponents;
import static java.util.stream.Collectors.groupingBy;

@Slf4j
@Controller
@RequestMapping("/build")
@SessionAttributes("assemblyOrder")
public class DesignAssemblyController {
    @Autowired
    private AssemblyToUDTConverter assemblyConverter;
    @Autowired
    private AssemblyRepository assemblyRepository;
    @GetMapping
    public String showDesignForm() {
        return "build";
    }

    @PostMapping
    public String processAssembly(ComputerAssembly createdAssembly,
                                  @ModelAttribute AssemblyOrder assemblyOrder) {
        log.info("Processing Assembly: {}", createdAssembly);
        assemblyRepository.save(createdAssembly);

        ComputerAssemblyUDT createdAssemblyUDT = assemblyConverter.convert(createdAssembly);
        assemblyOrder.add(createdAssemblyUDT);
        return "redirect:/orders/current";
    }

    @ModelAttribute(name = "assemblyOrder")
    public AssemblyOrder getOrder() {
        return new AssemblyOrder();
    }

    @ModelAttribute(name = "assembly")
    public ComputerAssembly getAssembly() {
        return new ComputerAssembly();
    }

    @ModelAttribute
    public void setConstituents(Model model) {
        List<Constituent> components = getActualComponents();
        components.stream()
                .collect(groupingBy(Constituent::getType))
                .forEach((type, typeComponents) ->
                        model.addAttribute(type.name().toLowerCase(), typeComponents));
    }
}
