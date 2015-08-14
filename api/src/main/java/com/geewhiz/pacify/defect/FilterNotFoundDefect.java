package com.geewhiz.pacify.defect;

import com.geewhiz.pacify.model.PArchive;
import com.geewhiz.pacify.model.PFile;
import com.geewhiz.pacify.model.PMarker;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

public class FilterNotFoundDefect implements Defect {

    private PMarker  pMarker;
    private PFile    pFile;
    private PArchive pArchive;

    public FilterNotFoundDefect(PMarker pMarker, PFile pFile) {
        this(pMarker, null, pFile);
    }

    public FilterNotFoundDefect(PMarker pMarker, PArchive pArchive, PFile pFile) {
        this.pMarker = pMarker;
        this.pArchive = pArchive;
        this.pFile = pFile;
    }

    public String getDefectMessage() {
        if (pArchive == null) {
            return String.format("FilterNotFoundFound: \n\t[MarkerFile=%s]\n\t[File=%s]\n\t[FilterClass=%s]", pMarker.getFile().getAbsolutePath(),
                    pFile.getRelativePath(), pFile.getFilterClass());
        } else {
            return String.format("FilterNotFoundFound: \n\t[MarkerFile=%s]\n\t[Archive=%s]\n\t[File=%s]\n\t[FilterClass=%s]", pMarker.getFile()
                    .getAbsolutePath(),
                    pArchive.getRelativePath(), pFile.getRelativePath(), pFile.getFilterClass());
        }

    }

}
