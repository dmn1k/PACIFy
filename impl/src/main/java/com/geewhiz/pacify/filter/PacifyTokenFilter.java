/*-
 * ========================LICENSE_START=================================
 * com.geewhiz.pacify.impl
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

package com.geewhiz.pacify.filter;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tools.ant.types.FilterSet;
import org.apache.tools.ant.types.FilterSetCollection;
import org.apache.tools.ant.util.FileUtils;

import com.geewhiz.pacify.defect.Defect;
import com.geewhiz.pacify.model.PFile;



public class PacifyTokenFilter implements PacifyFilter {

    public PacifyTokenFilter(PFile pFile) {
        // this filter doesn't need this parameters, but this constructor is needed.
    }

    @Override
    public LinkedHashSet<Defect> filter(Map<String, String> propertyValues, String beginToken, String endToken, File fileToFilter, String encoding) {
        FilterSetCollection filterSetCollection = getFilterSetCollection(propertyValues, beginToken, endToken);

        try {
            File tmpFile = com.geewhiz.pacify.utils.FileUtils.createEmptyFileWithSamePermissions(fileToFilter);

            FileUtils.getFileUtils().copyFile(fileToFilter, tmpFile, filterSetCollection, true, true, encoding);
            if (!fileToFilter.delete()) {
                throw new RuntimeException("Couldn't delete file [" + fileToFilter.getPath() + "]... Aborting!");
            }
            if (!tmpFile.renameTo(fileToFilter)) {
                throw new RuntimeException("Couldn't rename filtered file from [" + tmpFile.getPath() + "] to [" + fileToFilter.getPath() + "]... Aborting!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new LinkedHashSet<Defect>();
    }

    private FilterSetCollection getFilterSetCollection(Map<String, String> propertyValues, String beginToken, String endToken) {
        FilterSet filterSet = getFilterSet(propertyValues, beginToken, endToken);

        FilterSetCollection executionFilters = new FilterSetCollection();
        executionFilters.addFilterSet(filterSet);

        return executionFilters;
    }

    private FilterSet getFilterSet(Map<String, String> propertyValues, String beginToken, String endToken) {
        FilterSet filterSet = new FilterSet();

        filterSet.setBeginToken(beginToken);
        filterSet.setEndToken(endToken);

        for (Entry<String, String> entry : propertyValues.entrySet()) {
            filterSet.addFilter(entry.getKey(), entry.getValue());
        }
        return filterSet;
    }
}
