/*
 * Copyright 2008-2009 the original author or authors.
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

package org.broadleafcommerce.openadmin.server.service.persistence.entitymanager;

import org.hibernate.ejb.HibernateEntityManager;

/**
 * Created by IntelliJ IDEA.
 * User: jfischer
 * Date: 8/2/11
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DualEntityManager {

    public HibernateEntityManager getStandardManager();

    public HibernateEntityManager getSandboxManager();

}