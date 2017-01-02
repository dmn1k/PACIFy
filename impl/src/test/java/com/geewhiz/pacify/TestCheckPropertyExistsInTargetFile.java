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

package com.geewhiz.pacify;



import java.io.File;
import java.util.LinkedHashSet;

import org.junit.Assert;
import org.junit.Test;

import com.geewhiz.pacify.checks.impl.CheckPlaceholderExistsInTargetFile;
import com.geewhiz.pacify.defect.Defect;

public class TestCheckPropertyExistsInTargetFile extends TestBase {
    @Test
    public void checkForNotCorrect() {
        File testStartPath = new File("target/test-classes/checkPropertyExistsInTargetFileTest/wrong/package");

        LinkedHashSet<Defect> defects = getDefects(new CheckPlaceholderExistsInTargetFile(), testStartPath);

        Assert.assertEquals(3, defects.size());
    }

    @Test
    public void checkForCorrect() {
        File testStartPath = new File("target/test-classes/checkPropertyExistsInTargetFileTest/correct/package");

        LinkedHashSet<Defect> defects = getDefects(new CheckPlaceholderExistsInTargetFile(), testStartPath);

        Assert.assertEquals(0, defects.size());
    }

    @Test
    public void checkForCorrectWithCustomTokens() {
        File testStartPath = new File("target/test-classes/checkPropertyExistsInTargetFileCustomPlaceholderTest/correct/package");

        LinkedHashSet<Defect> defects = getDefects(new CheckPlaceholderExistsInTargetFile(), testStartPath);

        Assert.assertEquals(0, defects.size());
    }

    @Test
    public void checkForNotCorrectWithCustomTokens() {
        File testStartPath = new File("target/test-classes/checkPropertyExistsInTargetFileCustomPlaceholderTest/wrong/package");

        LinkedHashSet<Defect> defects = getDefects(new CheckPlaceholderExistsInTargetFile(), testStartPath);

        Assert.assertEquals(2, defects.size());
    }
}
