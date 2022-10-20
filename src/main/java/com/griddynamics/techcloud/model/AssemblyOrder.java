package com.griddynamics.techcloud.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class AssemblyOrder {
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    private UUID id = Uuids.timeBased();
    private Date placedAt = new Date();
    private String recipientName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryRegion;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    @Column("assemblies")
    private List<ComputerAssemblyUDT> assemblies = new ArrayList<>();

    public void add(ComputerAssemblyUDT assembly) {
        assemblies.add(assembly);
    }

    public void removeAssembly(int id) {
        assemblies.remove(id);
    }
}
