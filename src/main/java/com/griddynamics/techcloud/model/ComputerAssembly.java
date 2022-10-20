package com.griddynamics.techcloud.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Table("assemblies")
public class ComputerAssembly {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private UUID id = Uuids.timeBased();
    @NotBlank
    private String name;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING)
    private Date createdAt = new Date();
    @Column("components")
    private List<ConstituentUDT> components = new ArrayList<>();

    public void addIngredient(ConstituentUDT constituent) {
        components.add(constituent);
    }
}
