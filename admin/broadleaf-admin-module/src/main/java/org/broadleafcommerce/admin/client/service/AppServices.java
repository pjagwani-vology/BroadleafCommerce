/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.broadleafcommerce.admin.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * 
 * @author Phillip Verheyden
 *
 */
public class AppServices {
    
    public static final AdminCatalogServiceAsync CATALOG = GWT.create(AdminCatalogService.class);
    public static final AdminExporterServiceAsync EXPORT = GWT.create(AdminExporterService.class);

    static {
        ServiceDefTarget endpoint = (ServiceDefTarget) CATALOG;
        endpoint.setServiceEntryPoint("admin/admin.catalog.service");
        
        ServiceDefTarget endpoint2 = (ServiceDefTarget) EXPORT;
        endpoint2.setServiceEntryPoint("admin/admin.export.service");
    }
    
}
