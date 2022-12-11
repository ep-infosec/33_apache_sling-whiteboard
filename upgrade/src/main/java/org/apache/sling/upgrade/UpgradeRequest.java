/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.upgrade;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.stream.Collectors;

/**
 * Represents a request to update Apache Sling.
 */
public class UpgradeRequest {

    private final List<UpgradeEntry> entries = new ArrayList<>();
    private final String title;
    private final String vendor;
    private final String version;

    public UpgradeRequest(Manifest manifest) {
        Attributes attributes = manifest.getMainAttributes();
        title = attributes.getValue("Implementation-Title");
        vendor = attributes.getValue("Implementation-Vendor");
        version = attributes.getValue("Implementation-Version");
    }

    /**
     * @return the entries
     */
    public List<UpgradeEntry> getEntries() {
        return entries;
    }

    @SuppressWarnings("unchecked")
    public <E extends UpgradeEntry> List<E> getEntriesByType(Class<E> type) {
        return entries.stream().filter(e -> e.getClass().equals(type)).map(e -> (E) e).collect(Collectors.toList());
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

}
