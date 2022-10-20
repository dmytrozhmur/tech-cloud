package com.griddynamics.techcloud.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@UserDefinedType("constituent")
public class ConstituentUDT {
    private final String name;
    private final Constituent.Type type;
}
