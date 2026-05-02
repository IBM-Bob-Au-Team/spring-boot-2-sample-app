
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
/*
 */
package sample.actuator;

import jakarta.annotation.NotNull;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ServiceProperties {

    /**
     * Name of the service.
     */
    @Size(min = 1, message = "The service name must not be empty")
    @NotBlank(message = "The service name must not be empty")
    private String name = "World";

    /**
     * Gets the service name.
     *
     * @return the service name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the service name.
     *
     * @param name the service name to set
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }
}