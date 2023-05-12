package avl;

import java.util.Comparator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
  @DisplayName("Deleting elements from the tree, also checks balance of the tree")
  public class DeletingElementTest{

    @BeforeEach
    public void insertingElementOne(){
      avlTree.insert(1);
    }

    @Test
    @DisplayName("when deleting element one that is the only node, the avl tree is empty")
    public void When_DeletingTheElementOneOfTheAvlTree_Should_TheAvlTreeIsEmpty(){
      boolean obtainedValue;

      avlTree.delete(1);

      assertTrue(avlTree.avlIsEmpty());
    }

    @Nested
    @DisplayName("when adding element two")
    class DeletingElementsWithOnlyOneChild{
      @BeforeEach
      public void insertingElementTwo() {
        avlTree.insert(2);
      }

      @Test
      @DisplayName("when deleting element two and getting the top element must be one")
      public void When_DeletingElementTwoAndGettingTheTopElement_Should_GetTheElementOne(){
        int obtainedValue;
        int expectedValue = 1;

        avlTree.delete(2);

        obtainedValue = avlTree.getTop().getItem();

        assertEquals(expectedValue, obtainedValue);
      }

      @Test
      @DisplayName("when deleting element one and getting the top element must be two")
      public void When_DeletingElementOneAndGettingTheTopElement_Should_GetTheElementTwo(){
        int obtainedValue;
        int expectedValue = 2;

        avlTree.delete(1);

        obtainedValue = avlTree.getTop().getItem();

        assertEquals(expectedValue, obtainedValue);
      }

      @Test
      @DisplayName("when deleting element one and searching for this element, must return null because the element it is not found")
      public void When_DeletingElementOneAndSearchingItemOne_Should_NotFoundTheElementAndReturnsNull(){
        AvlNode<Integer> obtainedValue;

        avlTree.delete(1);

        obtainedValue = avlTree.search(1);

        assertNull(obtainedValue);
      }

      @Test
      @DisplayName("when deleting element two and searching for this element, must return null because the element it is not found")
      public void When_DeletingElementTwoAndSearchingItemTwo_Should_NotFoundTheElementAndReturnsNull(){
        AvlNode<Integer> obtainedValue;

        avlTree.delete(2);

        obtainedValue = avlTree.search(2);

        assertNull(obtainedValue);
      }

      @Test
      @DisplayName("when deleting element one and checkin if the top node is a leaf, must be true")
      public void When_DeletingElementOneAndCheckingIfTopNodeIsLeaf_Should_ReturnTrue(){
        boolean obtainedValue;

        avlTree.delete(2);

        obtainedValue = avlTree.getTop().isLeaf();

        assertTrue(obtainedValue);
      }

      @Nested
      @DisplayName("whe inserting element three")
      class DeletingElementsWithTwoOrMoreChildren{
        @BeforeEach
        public void insertingElementTwo() {
          avlTree.insert(3);
        }

        @Test
        @DisplayName("when deleting element three and getting the top element, must be two")
        public void When_DeletingElementThreeAndGettingTheTopElement_Should_GetTheElementTwo(){
          int obtainedValue;
          int expectedValue = 2;

          avlTree.delete(3);

          obtainedValue = avlTree.getTop().getItem();

          assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("when deleting element two and getting the top element, must be three")
        public void When_DeletingElementTwoAndGettingTheTopElement_Should_GetTheElementThree(){
          int obtainedValue;
          int expectedValue = 3;

          avlTree.delete(2);

          obtainedValue = avlTree.getTop().getItem();

          assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("when deleting element three and checking if the top has only left child, it must be true")
        public void When_DeletingElementThreeAndCheckingIfTheTopElementHasOnlyLeftChild_Should_ReturnTrue(){
          boolean obtainedValue;

          avlTree.delete(3);

          obtainedValue = avlTree.getTop().hasOnlyALeftChild();

          assertTrue(obtainedValue);
        }

        @Test
        @DisplayName("when deleting element one and checking if the top has only right child, it must be true")
        public void When_DeletingElementOneAndCheckingIfTheTopElementHasOnlyRightChild_Should_ReturnTrue(){
          boolean obtainedValue;

          avlTree.delete(1);

          obtainedValue = avlTree.getTop().hasOnlyARightChild();

          assertTrue(obtainedValue);
        }

        @Test
        @DisplayName("when deleting element two and checking if the top has only right child, it must be false")
        public void When_DeletingElementTwoAndCheckingIfTheTopElementHasOnlyRightChild_Should_ReturnFalse(){
          boolean obtainedValue;

          avlTree.delete(2);

          obtainedValue = avlTree.getTop().hasOnlyARightChild();

          assertFalse(obtainedValue);
        }

        @Test
        @DisplayName("when deleting element one and checking if the top is smaller than the right child, it must be true")
        public void When_DeletingElementOneAndCheckingIfTheTopElementSmallerThanTheRightChild_Should_ReturnTrue(){
          boolean obtainedValue;

          avlTree.delete(1);

          obtainedValue = avlTree.getTop().getRight().getItem() > avlTree.getTop().getItem();

          assertTrue(obtainedValue);
        }

        @Test
        @DisplayName("when deleting element two and checking if the top is bigger than the left child, it must be true")
        public void When_DeletingElementTwoAndCheckingIfTheTopElementBiggerThanTheLeftChild_Should_ReturnTrue(){
          boolean obtainedValue;

          avlTree.delete(2);

          obtainedValue = avlTree.getTop().getLeft().getItem() < avlTree.getTop().getItem();

          assertTrue(obtainedValue);
        }

        @Test
        @DisplayName("when deleting element three and checking if the top is bigger than the left child, it must be true")
        public void When_DeletingElementThreeAndCheckingIfTheTopElementBiggerThanTheLeftChild_Should_ReturnTrue(){
          boolean obtainedValue;

          avlTree.delete(3);

          obtainedValue = avlTree.getTop().getLeft().getItem() < avlTree.getTop().getItem();

          assertTrue(obtainedValue);
        }

        @Test
        @DisplayName("when deleting element one and checking if the top has only left child, it must be false")
        public void When_DeletingElementOneAndCheckingIfTheTopElementHasOnlyLeftChild_Should_ReturnFalse(){
          boolean obtainedValue;

          avlTree.delete(1);

          obtainedValue = avlTree.getTop().hasOnlyALeftChild();

          assertFalse(obtainedValue);
        }

        @Test
        @DisplayName("when deleting element one and getting the top element, must return element two")
        public void When_DeletingElementOneAndGettingTheTopElement_Should_GetTheElementTwo(){
          int obtainedValue;
          int expectedValue = 2;

          avlTree.delete(1);

          obtainedValue = avlTree.getTop().getItem();

          assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("when deleting element three and searching for this element, must return null because it is not found")
        public void When_DeletingElementThreeAndSearchingItemThree_Should_NotFoundTheElementAndReturnsNull(){
          AvlNode<Integer> obtainedValue;

          avlTree.delete(3);

          obtainedValue = avlTree.search(3);

          assertNull(obtainedValue);
        }

        @Test
        @DisplayName("when inserting element four and deleting element three after getting right child, must return element four")
        public void When_InsertingElementFourDeletingElementThreeAndGettingRightChildrenOfTopNode_Should_ReturnElementFour(){
          Integer obtainedValue;
          Integer expectedValue = 4;

          avlTree.insert(4);
          avlTree.delete(3);

          obtainedValue = avlTree.getTop().getRight().getItem();

          assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("when inserting element four, deleting element three and checking if the top element is smaller than the right child, must return true")
        public void When_InsertingElementFourDeletingElementThreeAndCheckingIfTheTopElementIsSmallerThanTheRightChild_Should_ReturnTrue(){
          boolean obtainedValue;

          avlTree.insert(4);
          avlTree.delete(3);

          obtainedValue = avlTree.getTop().getRight().getItem() > avlTree.getTop().getItem();

          assertTrue(obtainedValue);
        }

        @Test
        @DisplayName("when inserting element four, deleting element three and checking if the top element is bigger than the left child, must return true")
        public void When_InsertingElementFourDeletingElementThreeAndCheckingIfTheTopElementIsBiggerThanTheLeftChild_Should_ReturnTrue(){
          boolean obtainedValue;

          avlTree.insert(4);
          avlTree.delete(3);

          obtainedValue = avlTree.getTop().getLeft().getItem() < avlTree.getTop().getItem();

          assertTrue(obtainedValue);
        }
      }
    }

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
