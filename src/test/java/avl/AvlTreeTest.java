package avl;

import java.util.Comparator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Search tests")
    class SearchTests{
        @Test
        @DisplayName("When inserting an item, search method should return the node that contains the item")
        void WhenInsertingAnItemSearchMethodShouldReturnTheNodeThatContainsTheItemTest() {
            AvlNode<Integer> node = new AvlNode<>(5);
            avlTree.insertAvlNode(node);

            Integer expectedValue = 5;
            Integer obtainedValue = avlTree.search(5).getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("When inserting a node, searchNode method should return the node")
        void WhenInsertingANodeSearchNodeMethodShouldReturnTheNodeTest() {
            AvlNode<Integer> node = new AvlNode<>(5);
            avlTree.insertAvlNode(node);

            AvlNode<Integer> expectedValue = node;
            AvlNode<Integer> obtainedValue = avlTree.searchNode(node);

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("When searching for a node that is not in the tree, searchNode method should return null")
        void WhenSearchingForANodeThatIsNotInTheTreeSearchNodeMethodShouldReturnNullTest() {

            AvlNode<Integer> expectedValue = null;
            AvlNode<Integer> obtainedValue = avlTree.search(3);

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("When searching closest node with the only item in the tree, searchClosestNode method should return -1")
        void WhenSearchingClosestNodeWithTheOnlyItemInTheTreeSearchClosestNodeMethodShouldReturnMinusOneTest() {
            AvlNode<Integer> node = new AvlNode<>(5);
            avlTree.insertAvlNode(node);

            AvlNode<Integer> insertedNode = new AvlNode<>(3);

            Integer expectedValue = -1;
            Integer obtainedValue = avlTree.searchClosestNode(insertedNode);

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("When avlTree contains an item and a successor, findSuccessor method should return the successor")
        void WhenAvlTreeContainsAnItemAndASuccessorFindSuccessorMethodShouldReturnTheSuccessorTest() {
            AvlNode<Integer> node1 = new AvlNode<>(5);
            avlTree.insertAvlNode(node1);
            AvlNode<Integer> node2 = new AvlNode<>(6);
            avlTree.insertAvlNode(node2);

            AvlNode<Integer> expectedValue = node2;
            AvlNode<Integer> obtainedValue = avlTree.findSuccessor(node1);

            assertEquals(expectedValue, obtainedValue);
        }

    }


}
