/*-
 * ========================LICENSE_START=================================
 * com.geewhiz.pacify.api
 * %%
 * Copyright (C) 2011 - 2017 Sven Oppermann
 * %%
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
 * =========================LICENSE_END==================================
 */

package com.geewhiz.pacify.resolver;



import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.tools.ant.types.FilterSet;

import com.geewhiz.pacify.defect.Defect;

public interface PropertyResolver extends Comparable<PropertyResolver> {

    boolean containsProperty(String property);

    boolean isProtectedProperty(String property);

    String getPropertyValue(String key);

    Set<String> getReferencedProperties(String property);

    Set<String> getPropertyKeys();

    String getEncoding();

    String getPropertyResolverDescription();

    LinkedHashSet<Defect> checkForDuplicateEntry();

    FilterSet createFilterSet();

    boolean propertyUsesToken(String property);

    String getBeginToken();

    String getEndToken();

}
