package DepositStuff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

  private ListADT<String>list;

  @BeforeEach void setUp() {
    list = new ArrayList<>();
  }
  //5. get(int index)
  //TODO: change type of thrown exception to IndexOutOfBoundsException
  @Test
  void getZeroIndexElementFromEmpty(){
    //Z1 - get element at index 0 in empty ArrayList - expect exception
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
  }

  @Test
  void getZeroIndexElementFromFilled(){
    //Z2 - get element at index 0 in ArrayList with 3 elements
    list.add("a");
    list.add("b");
    list.add("c");
    assertEquals("a", list.get(0));
  }

  @Test
  void getFirstIndexElementFromFilledWithThree(){
    //O - get element at index 1 in ArrayList with 3 elements
    list.add("a");
    list.add("b");
    list.add("c");
    assertEquals("b", list.get(1));
  }


  @Test
  void getFirstIndexElementFromFilledWithFive(){
    //M - get element at index 3 in ArrayList with 5 elements
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    assertEquals("d", list.get(3));
  }

  @Test
  void getMinusIndexElement(){
    //B1 - get element at index -1 - expect exception
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
  }


  @Test
  void getElementOutOfBounds(){
    //B2 - get element at index 3 in ArrayList with 2 elements
    list.add("a");
    list.add("b");
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
  }

  //B3 - get element at index 3 in ArrayList with 1 element - expect exception
  @Test
  void getElementOutOfBoundsV2(){
    //B2 - get element at index 3 in ArrayList with 2 elements
    list.add("a");
    list.add("b");
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
  }


  //6. indexOf(T element)
  //TODO: none
  @Test
  void indexOfElementInEmpty(){
    //Z - index of element in empty ArrayList - expect -1
    assertEquals(-1, list.indexOf("a"));
  }

  @Test
  void indexOfElementInFilledWithOne(){
    //O - index of element in ArrayList with 1 element - expect found
    list.add("a");
    assertEquals(0, list.indexOf("a"));
  }

  @Test
  void indexOfElementInFilledWithThree(){
    //M1 - index of element in ArrayList with 3 elements - expect found
    list.add("a");
    list.add("b");
    list.add("c");
    assertEquals(1, list.indexOf("b"));
  }

  @Test
  void indexOfElementInFilledWithThreeOutOfBound(){
    //M2 - index of element in ArrayList with 3 elements - expect not found
    list.add("a");
    list.add("b");
    list.add("c");
    assertEquals(-1, list.indexOf("d"));
  }
}