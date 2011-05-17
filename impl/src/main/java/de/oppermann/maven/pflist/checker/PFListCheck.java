package de.oppermann.maven.pflist.checker;

import de.oppermann.maven.pflist.defect.Defect;
import de.oppermann.maven.pflist.xml.PFList;

import java.util.List;

/**
 * User: sop
 * Date: 03.05.11
 * Time: 13:05
 */
public interface PFListCheck {

    /**
     * @param pfList which pfList should be checked?
     * @return if there are defects, return a list with the defects.
     */
    List<Defect> checkForErrors(PFList pfList);
}