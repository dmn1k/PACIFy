/*-
 * ========================LICENSE_START=================================
 * com.geewhiz.pacify.resolver.file-resolver
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

package com.geewhiz.pacify.property.resolver.fileresolver.exceptions;



public class WrongPropertyLineRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String            line;

    public WrongPropertyLineRuntimeException() {
        super();
    }

    public WrongPropertyLineRuntimeException(String line) {
        super("Property line isn't correct [" + line + "]. Format has to be <property>=<value>.");
        this.setLine(line);
    }

    public String getLine() {
        return line;
    }

    private void setLine(String property) {
        this.line = property;
    }
}
