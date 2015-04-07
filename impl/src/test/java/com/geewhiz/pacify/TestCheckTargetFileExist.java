package com.geewhiz.pacify;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.geewhiz.pacify.defect.Defect;

import java.io.File;
import java.util.List;

/**
 * User: sop
 * Date: 03.05.11
 * Time: 13:05
 */
public class TestCheckTargetFileExist extends BaseCheck {

    @Test
    public void checkForNotCorrect() {
        File testStartPath = new File("target/test-classes/checkTargetFileExistTest/wrong");

        List<Defect> defects = getDefects(new com.geewhiz.pacify.checker.CheckTargetFileExist(), testStartPath);

        Assert.assertEquals(2, defects.size());
    }

    @Test
    public void checkForCorrect() {
        File testStartPath = new File("target/test-classes/checkTargetFileExistTest/correct");

        List<Defect> defects = getDefects(new com.geewhiz.pacify.checker.CheckTargetFileExist(), testStartPath);

        Assert.assertEquals(0, defects.size());
    }


}