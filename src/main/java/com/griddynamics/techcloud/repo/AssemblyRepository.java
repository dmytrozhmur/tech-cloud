package com.griddynamics.techcloud.repo;

import com.griddynamics.techcloud.model.ComputerAssembly;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AssemblyRepository extends CrudRepository<ComputerAssembly, UUID> {
}
