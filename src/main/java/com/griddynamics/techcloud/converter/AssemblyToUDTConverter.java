package com.griddynamics.techcloud.converter;

import com.griddynamics.techcloud.model.ComputerAssembly;
import com.griddynamics.techcloud.model.ComputerAssemblyUDT;
import org.springframework.stereotype.Component;

@Component
public class AssemblyToUDTConverter {
    public ComputerAssemblyUDT convert(ComputerAssembly assembly) {
        return new ComputerAssemblyUDT(assembly.getName(), assembly.getComponents());
    }
}
