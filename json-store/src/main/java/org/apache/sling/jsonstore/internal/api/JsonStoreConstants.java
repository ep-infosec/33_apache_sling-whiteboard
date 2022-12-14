/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

 package org.apache.sling.jsonstore.internal.api;

public class JsonStoreConstants {
    public static final String STORE_ROOT_PATH = "/content/sites";
    public static final String JSON_PROP_NAME = "json";

    public static final String FOLDER_RESOURCE_TYPE = "sling/jsonstore/folder";
    public static final String SCHEMA_RESOURCE_TYPE = "sling/jsonstore/schema";
    public static final String ELEMENTS_RESOURCE_TYPE = "sling/jsonstore/element";
    public static final String CONTENT_RESOURCE_TYPE = "sling/jsonstore/content";
    public static final String COMMAND_RESOURCE_TYPE = "sling/jsonstore/command";

    public static final String JSON_SCHEMA_FIELD = "$schema";
    
    private JsonStoreConstants() {}
}
