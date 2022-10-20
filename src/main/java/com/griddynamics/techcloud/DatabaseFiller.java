package com.griddynamics.techcloud;

import com.griddynamics.techcloud.model.Constituent;
import com.griddynamics.techcloud.repo.ConstituentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.griddynamics.techcloud.utils.DataBase.getActualComponents;

@Component
public class DatabaseFiller {
    @Autowired
    private ConstituentRepository constituentRepository;

    public void fill() {
        List<Constituent> initialData = getActualComponents();
        constituentRepository.saveAll(initialData);
    }
}
