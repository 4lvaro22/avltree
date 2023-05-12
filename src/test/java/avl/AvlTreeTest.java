package avl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.*;

/**
 * Created with IntelliJ IDEA. User: Antonio J. Nebro Date: 08/07/13
 */
public class AvlTreeTest {

  AvlTree<Integer> avlTree;
  Comparator<?> comparator;

  @BeforeEach
  public void setUp() throws Exception {
    comparator = Comparator.comparingInt((Integer o) -> o);
    avlTree = new AvlTree(comparator);
  }

  @AfterEach
  public void tearDown() throws Exception {
    avlTree = null;
    comparator = null;
  }


  @Nested
  @DisplayName("Tests for insertion method, also proofs balance")
  class insertionTests {


    @Test
    @DisplayName("Should insert into the top of the tree when you call insert method for the first time")
    public void testInsercionArbolVacio() {

      avlTree.insert(5);
      assertTrue(avlTree.search(5) != null);
      int obtainedValue = avlTree.getTop().getItem();
      int expectedValue = 5;

      assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Should insert into right of the top node when you add a second node to the tree that is bigger than the top one")
    public void testInsercionMayorArbolConUnNodo() {

      avlTree.insert(5);

      avlTree.insert(9);
      assertTrue(avlTree.search(9) != null);
      int obtainedValue = avlTree.getTop().getRight().getItem();
      int expectedValue = 9;

      int obtainedValue2 = avlTree.getTop().getItem();
      int expectedValue2 = 5;

      assertEquals(expectedValue, obtainedValue);
      assertEquals(expectedValue2, obtainedValue2);
    }

    @Test
    @DisplayName("Should insert into left of the top node when you add a second node to the tree that is lower than the top one")
    public void testInsercionMenorArbolConUnNodo() {

      avlTree.insert(5);

      avlTree.insert(3);
      assertTrue(avlTree.search(3) != null);
      int obtainedValue = avlTree.getTop().getLeft().getItem();
      int expectedValue = 3;

      int obtainedValue2 = avlTree.getTop().getItem();
      int expectedValue2 = 5;

      assertEquals(expectedValue, obtainedValue);
      assertEquals(expectedValue2, obtainedValue2);
    }

    @Test
    @DisplayName("Shoud insert in the correct position different values when insert method is called several times with different values")
    public void testInsercionArbolConVariosNodos() {

      avlTree.insert(5);
      avlTree.insert(2);
      avlTree.insert(8);

      avlTree.insert(1);
      assertTrue(avlTree.search(1) != null);
      int obtainedValue = avlTree.getTop().getLeft().getLeft().getItem();
      int expectedValue = 1;

      avlTree.insert(7);
      assertTrue(avlTree.search(7) != null);
      int obtainedValue2 = avlTree.getTop().getRight().getLeft().getItem();
      int expectedValue2 = 7;

      assertEquals(expectedValue, obtainedValue);
      assertEquals(expectedValue2, obtainedValue2);
    }


  }

  @Nested
  @DisplayName("Test order of the tree")
  class OrderTests {

   @Test
   @DisplayName("Should return a string with all the items of the tree starting with the top one when the toString method is called")
    public void inOrderTest () {

     avlTree.insert(3);
     avlTree.insert(7);
     avlTree.insert(1);
     avlTree.insert(5);

     String expectedValue = " | 3 | 1 | 7 | 5";
     String obtainedValue = avlTree.toString();
     assertEquals(avlTree.getTop().getItem(), 3 );
     assertEquals(expectedValue,obtainedValue);

    }

  }






}
