
package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for package Model.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
@RunWith(Suite.class)
@SuiteClasses({
    ElementIT.class,
    IntroIT.class,
    MazeIT.class,
    MazeListIT.class,
    MutationIT.class,
    PopulationIT.class,
    SnailIT.class,
    TransferIT.class
}
)

public class TestSuite {
}
