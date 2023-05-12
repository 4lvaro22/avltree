package avl;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* CASOS DE PRUEBA -
 *   1. Nodo vacío
 *      1.1. testNullNode() -> Comprobar que cuando se crea un nodo (null), el propio nodo,los hijos, el padre y el nodo más cercano son nulos y la altura es 0
 *   2. Un nodo
 *      2.1. testConstructorAndGetters() -> Comprobar que cuando se crea un nodo (10), los hijos, el padre y el nodo más cercano son nulos y la altura es 0
 *   3. Sólo hijo izquierda
 *      3.1. testOnlyLeftChild() -> Comprobar que cuando se crea un nodo (5), el árbol sólo tiene hijos a la izquierda y no a la derecha
 *   4. Sólo hijo derecha
 *      4.1 testOnlyRightChild() -> Comprobar que cuando se crea un nodo (15), el árbol sólo tiene hijos a la derecha y no a la izquierda
 *   5. Caso normal (padre e hijos en ambos lados)
 *      5.1
 *
 *
 * 2. testSetterAndGetters() -> Comprobar que cuando creas un posible árbol completo (padre, hijos y nodo cercano) con los setters y obtienes el valor con getters, es correcto
 * */
public class AvlNodeTest {

    @Nested
    @DisplayName("given an empty avlNode")
    class emptyAvlNode{

        @Test
        @DisplayName("n")
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

    }

    @Nested
    @DisplayName("given an only left child avl tree")
    class onlyLeftAvlTree{

    }

    @Nested
    @DisplayName("given an only righ child avl tree")
    class onlyRightAvlTree{

    }

    @Nested
    @DisplayName("given an only left child avl tree")
    class normalCaseAvlTree{

    }

    @Test
    public void testUpdateHeight() {
        // Arrange
        AvlNode<Integer> node = new AvlNode<>(10);
        AvlNode<Integer> left = new AvlNode<>(5);
        AvlNode<Integer> right = new AvlNode<>(15);
        left.setHeight(1);
        right.setHeight(2);
        node.setLeft(left);
        node.setRight(right);

        // Act
        node.updateHeight();

        // Assert
        assertEquals(3, node.getHeight());
    }

    @Test
    public void testConstructorAndGetters() {
        Integer item = 10;

        AvlNode<Integer> node = new AvlNode<>(item);

        assertEquals(item, node.getItem());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
        assertEquals(null, node.getParent());
        assertEquals(null, node.getClosestNode());
        assertEquals(0, node.getHeight());
    }

    @Test
    public void testOnlyLeftChild(){
        AvlNode<Integer> node = new AvlNode<>(10);
        AvlNode<Integer> left = new AvlNode<>(5);

        node.setLeft(left);

        assertEquals(left, node.getLeft());
        assertTrue(node.hasOnlyALeftChild());
        assertFalse(node.hasOnlyARightChild());
        assertFalse(node.hasParent());
    }

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





}
