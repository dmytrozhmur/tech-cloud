package com.griddynamics.techcloud.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table("constituents")
public class Constituent {
    @PrimaryKey
    private String id;
    private String name;
    private Type type;

    public enum Type {
        CPU,
        CASE,
        ADAPTER,
        VIDEO_CARD,
        SOUND_CARD,
        HARD_DRIVE,
        POWER_UNIT,
        MOTHERBOARD,
        MEMORY_MODULE,
        COOLING_SYSTEM
    }
}
