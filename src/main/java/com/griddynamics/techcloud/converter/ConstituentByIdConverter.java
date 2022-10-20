package com.griddynamics.techcloud.converter;

import com.griddynamics.techcloud.model.Constituent;
import com.griddynamics.techcloud.model.ConstituentUDT;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import static com.griddynamics.techcloud.utils.DataBase.getActualComponents;

@Component
public class ConstituentByIdConverter implements Converter<String, ConstituentUDT> {
    private final Map<String, ConstituentUDT> idConstituentMap = new HashMap<>();

    public ConstituentByIdConverter() {
        List<Constituent> components = getActualComponents();
        components.forEach(el -> idConstituentMap
                .put(el.getId(), new ConstituentUDT(el.getName(), el.getType())));
    }

    @Override
    public ConstituentUDT convert(String id) {
        return idConstituentMap.get(id);
    }
}
