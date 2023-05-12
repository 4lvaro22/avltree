package avl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AvlNodeTest {

  @Test
  @DisplayName("Create several nodes, set right and left children and check with getters kinship")
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
  @DisplayName("Given an empty AvlNode")
  class emptyAvlNode {

    @Test
    @DisplayName("when creating a node with null value, all values expected are null")
    void testNullNode() {
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
  @DisplayName("Given an avl tree with only one node")
  class avlTreeWithOneNode {
    AvlNode<Integer> node;

    @BeforeEach
    public void setUp(){
      node = new AvlNode<>(10);
    }

    @Test
    @DisplayName("when getting a node with 10 value, the expected value is 10, and parent, lef, right and closest node is null")
    public void testConstructorAndGetters() {
      assertEquals(10, node.getItem());
      assertEquals(null, node.getLeft());
      assertEquals(null, node.getRight());
      assertEquals(null, node.getParent());
      assertEquals(null, node.getClosestNode());
    }

    @Test
    @DisplayName("when the item is updated then the value is correctly updated")
    public void testUpdateItem(){
      node.setItem(11);
      assertEquals(11, node.getItem());
    }

    @Test
    @DisplayName("when we check if it a leaf, return true")
    public void testNodeWithoutChildrenIsLeaf(){
      assertTrue(node.isLeaf());
    }
  }

  @Nested
  @DisplayName("Given a node with only left child")
  class onlyLeftAvlTree {
    @Test
    @DisplayName("when getting a node 5 value, the expected values is 5, has a parent 10, there is no right child")
    public void testOnlyLeftChild() {
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
  @DisplayName("Given a node with only right child")
  class onlyRightAvlTree {

    @Test
    @DisplayName("when getting a node 15 value, the expected values is 15, has a parent 10, there is no left child")
    public void testOnlyRightChild() {
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
  @DisplayName("Given a node with left and right children")
  class normalCaseAvlTree {

    AvlNode<Integer> node;
    AvlNode<Integer> left;
    AvlNode<Integer> right;

    @BeforeEach
    public void setUp(){
      node = new AvlNode<>(10);
      left = new AvlNode<>(5);
      right = new AvlNode<>(15);
    }

    @Test
    @DisplayName("when getting the parent 10, left child 5 and right child 15, the expected values are 10, 5 and 15")
    public void testGettingParentLeftAndRightChildren() {
      node.setLeft(left);
      node.setRight(right);
      node.setHeight(2);

      assertEquals(left, node.getLeft());
      assertEquals(right, node.getRight());
      assertEquals(2, node.getHeight());
    }

    @Test
    @DisplayName("when we check before and after adding the children, the height is correctly updated")
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
}
