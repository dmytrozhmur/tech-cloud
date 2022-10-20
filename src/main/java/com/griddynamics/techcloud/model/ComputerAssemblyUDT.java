package com.griddynamics.techcloud.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@UserDefinedType("assembly")
public class ComputerAssemblyUDT {
    private final String name;
    private final List<ConstituentUDT> components;
}
