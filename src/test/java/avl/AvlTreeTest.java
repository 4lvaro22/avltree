package avl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: Antonio J. Nebro Date: 08/07/13
 */
public class AvlTreeTest {

  AvlTree<Integer> avlTree;
  Comparator<?> comparator;

  @Before
  public void setUp() throws Exception {
    comparator = Comparator.comparingInt((Integer o) -> o);
    avlTree = new AvlTree(comparator);
  }

  @After
  public void tearDown() throws Exception {
    avlTree = null;
    comparator = null;
  }

}
