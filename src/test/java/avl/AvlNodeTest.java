package avl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
/* CASOS DE PRUEBA -
 *   1. testSetterAndGetters() -> Comprobar que cuando creas un posible árbol completo (padre, hijos y nodo cercano) con los setters y obtienes el valor con getters, es correcto
 *   2. Nodo vacío
 *      2.1. testNullNode() -> Comprobar que cuando se crea un nodo (null), el propio nodo,los hijos, el padre y el nodo más cercano son nulos y la altura es 0
 *   3. Un nodo
 *      3.1. testConstructorAndGetters() -> Comprobar que cuando se crea un nodo (10), los hijos, el padre y el nodo más cercano son nulos y la altura es 0
 *   4. Sólo hijo izquierda
 *      4.1. testOnlyLeftChild() -> Comprobar que cuando se crea un nodo (5), el árbol sólo tiene hijos a la izquierda y no a la derecha
 *   5. Sólo hijo derecha
 *      5.1 testOnlyRightChild() -> Comprobar que cuando se crea un nodo (15), el árbol sólo tiene hijos a la derecha y no a la izquierda
 *   6. Caso normal (padre e hijos en ambos lados)
 *      6.1
 * */
public class AvlNodeTest {

    @Test
    public void testSettersAndGetters() {
        AvlNode<Integer> node = new AvlNode<>(10);
        AvlNode<Integer> left = new AvlNode<>(5);
        AvlNode<Integer> right = new AvlNode<>(15);
        AvlNode<Integer> parent = new AvlNode<>(20);
        AvlNode<Integer> closestNode = new AvlNode<>(7);

        node.setLeft(left);
        node.setRight(right);
        node.setParent(parent);
        node.setClosestNode(closestNode);
        node.setHeight(2);

        assertEquals(left, node.getLeft());
        assertEquals(right, node.getRight());
        assertEquals(parent, node.getParent());
        assertEquals(closestNode, node.getClosestNode());
        assertEquals(2, node.getHeight());
    }


    @Nested
    @DisplayName("given an empty avlNode")
    class emptyAvlNode{

        @Test
        @DisplayName("when creating a node with null value, all values expected are null")
        void testNullNode(){
            AvlNode<Integer> node = new AvlNode<>(null);

            assertNull(node.getItem());
            assertNull(node.getLeft());
            assertNull(node.getRight());
            assertNull(node.getParent());
            assertNull(node.getClosestNode());
            assertEquals(0, node.getHeight());
        }
    }

    @Nested
    @DisplayName("given an avl tree with one node")
    class avlTreeWithOneNode{
        @Test
        @DisplayName("when getting a node with 10 value, the expected value is 10, and parent, lef, right and closest node is null")
        public void testConstructorAndGetters() {
            Integer item = 10;

            AvlNode<Integer> node = new AvlNode<>(item);

            assertEquals(item, node.getItem());
            assertEquals(null, node.getLeft());
            assertEquals(null, node.getRight());
            assertEquals(null, node.getParent());
            assertEquals(null, node.getClosestNode());
        }
    }

    @Nested
    @DisplayName("given an only left child avl tree")
    class onlyLeftAvlTree{
        @Test
        @DisplayName("when getting a node 5 value, the expected values is 5, has a parent 10, there is no right child")
        public void testOnlyLeftChild(){
            AvlNode<Integer> node = new AvlNode<>(10);
            AvlNode<Integer> left = new AvlNode<>(5);

            node.setLeft(left);

            assertEquals(left, node.getLeft());
            assertTrue(node.hasOnlyALeftChild());
            assertFalse(node.hasOnlyARightChild());
            assertFalse(node.hasParent());
        }
    }

    @Nested
    @DisplayName("given an only right child avl tree")
    class onlyRightAvlTree{

        @Test
        @DisplayName("when getting a node 15 value, the expected values is 15, has a parent 10, there is no left child")
        public void testOnlyRightChild(){
            AvlNode<Integer> node = new AvlNode<>(10);
            AvlNode<Integer> right = new AvlNode<>(15);

            node.setRight(right);

            assertEquals(right, node.getRight());
            assertFalse(node.hasOnlyALeftChild());
            assertTrue(node.hasOnlyARightChild());
            assertFalse(node.hasParent());
        }
    }

    @Nested
    @DisplayName("given a node with left and right children")
    class normalCaseAvlTree{

        @Test
        @DisplayName("when getting the parent 10, left child 5 and right child 15, the expected values are 10, 5 and 15")
        public void testGettingParentLeftAndRightChildre(){
            AvlNode<Integer> node = new AvlNode<>(10);
            AvlNode<Integer> left = new AvlNode<>(5);
            AvlNode<Integer> right = new AvlNode<>(15);

            node.setLeft(left);
            node.setRight(right);
            node.setHeight(2);

            assertEquals(left, node.getLeft());
            assertEquals(right, node.getRight());
            assertEquals(2, node.getHeight());
        }

        @Test
        @DisplayName("---")
        public void testUpdateHeight() {
            AvlNode<Integer> node = new AvlNode<>(10);
            AvlNode<Integer> left = new AvlNode<>(5);
            AvlNode<Integer> right = new AvlNode<>(15);

            assertEquals(0, node.getHeight());

            node.setLeft(left);
            node.setRight(right);

            node.updateHeight();

            assertEquals(1, node.getHeight());
        }
    }






=======
/**
 * Created with IntelliJ IDEA. User: Antonio J. Nebro Date: 09/07/13 Time: 15:29
 */
public class AvlNodeTest {

  private AvlNode<Integer> node;

  @Before
  public void setUp() throws Exception {
    node = new AvlNode<Integer>(5);
  }

  @After
  public void tearDown() throws Exception {
    node = null;
  }

  @Test
  public void testHasLeft() {
    assertFalse("testHasLeft", node.hasLeft());
    AvlNode<Integer> node2 = new AvlNode<Integer>(6);
    node.setLeft(node2);
    assertTrue("testHasLeft", node.hasLeft());
  }

  @Test
  public void testHasRight() {
    assertFalse("testHasRight", node.hasRight());
    AvlNode<Integer> node2 = new AvlNode<Integer>(6);
    node.setRight(node2);
    assertTrue("testHasRight", node.hasRight());
  }

  @Test
  public void shouldSetHeight() {
    int expectedHeight = 1000213;
    node.setHeight(expectedHeight);
    assertEquals("Height is different from expected.", expectedHeight, node.getHeight());
  }
>>>>>>> main
}
