package com.griddynamics.techcloud.repo;

import com.griddynamics.techcloud.model.AssemblyOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<AssemblyOrder, UUID> {
}
