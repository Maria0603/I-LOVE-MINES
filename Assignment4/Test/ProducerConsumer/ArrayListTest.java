package ProducerConsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest<T>
{

  private ListADT<String> arrayList;

  @BeforeEach void setUp()
  {
    arrayList = new ArrayList<>();
  }

  /*
  1. ArrayList()
  Z - check the ArrayList to be empty
  O - not relevant
  M - not relevant
  B - not relevant
  E - none
 */

  //The ArrayList is empty - passed
  @Test void ArrayList_Zero_ZeroElements()
  {
    ArrayList<T> test = assertDoesNotThrow(() -> new ArrayList<>());
    assertEquals("{}", test.toString());
  }

  /*
  2. add(int index, T element)
  Z1 - add element at index 0 in empty ArrayList
  Z2 - add element at index 0 in ArrayList with 3 elements
  Z3 - add null element at index 0 in empty ArrayList
  Z4 - all null element at index 0 in ArrayList with 3 elements
  O1 - add element at index 1 in empty ArrayList - expect exception
  O2 - add element at index 1 in ArrayList with 1 element
  M1 - add 3 elements in ArrayList with 2 elements
  M2 - add 3 null elements in ArrayList with 3 elements
  B1 - add element at index -1 - expect exception
  B2 - add 16 elements
  B3 - add 17 elements
  E - tested in One and Bounds
 */

  //The ArrayList contains the new element - Passed
  @Test void add_Zero1_IndexZero_EmptyArrayList()
  {
    assertDoesNotThrow(() -> arrayList.add(0, "Element"));
    assertEquals("{Element}", arrayList.toString());
  }

  //The ArrayList contains the new element - Passed
  @Test void add_Zero2_IndexZero_ThreeElements()
  {
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    assertDoesNotThrow(() -> arrayList.add(0, "d"));
    assertEquals("{d, a, b, c}", arrayList.toString());
  }

  //The ArrayList contains the null element - Passed
  @Test void add_Zero3_NullElement_IndexZero_EmptyArrayList()
  {
    assertDoesNotThrow(() -> arrayList.add(0, null));
    assertEquals("{null}", arrayList.toString());
  }

  //The null element has been successfully added - Passed
  @Test void add_Zero4_NullElement_IndexZero_ThreeElements()
  {
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    assertDoesNotThrow(() -> arrayList.add(0, null));
    assertEquals("{null, a, b, c}", arrayList.toString());
  }

  //Passed
  @Test void add_One1_IndexOne_EmptyArrayList()
  {
    assertThrows(IndexOutOfBoundsException.class,
        () -> arrayList.add(1, "Element"));
  }

  //The ArrayList contains the new element - Passed
  @Test void add_One2_IndexOne_OneElement()
  {
    arrayList.add("a");
    assertDoesNotThrow(() -> arrayList.add(0, "b"));
    assertEquals("{b, a}", arrayList.toString());
  }

  //The ArrayList contains the new elements at the specified indexes - passed
  @Test void add_Many1_ThreeElementsInTwoElementsArrayList()
  {
    //a d e b c
    arrayList.add("a");
    arrayList.add("b");
    assertDoesNotThrow(() -> arrayList.add(2, "c"));
    assertDoesNotThrow(() -> arrayList.add(1, "d"));
    assertDoesNotThrow(() -> arrayList.add(2, "e"));
    assertEquals("{a, d, e, b, c}", arrayList.toString());
  }

  //The ArrayList contains all the added elements - Passed
  @Test void add_Many2_ThreeNullElements_ThreeElementsArrayList()
  {
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    assertDoesNotThrow(() -> arrayList.add(null));
    assertDoesNotThrow(() -> arrayList.add(null));
    assertDoesNotThrow(() -> arrayList.add(null));
    assertEquals("{a, b, c, null, null, null}", arrayList.toString());
  }

  //Passed
  @Test void add_Bounds1_NegativeIndex()
  {
    assertThrows(IndexOutOfBoundsException.class,
        () -> arrayList.add(-1, "Element"));
  }

  //Passed
  @Test void add_Bounds2_16Elements()
  {
    for (int i = 0; i < 15; i++)
      arrayList.add(i, "Element " + i);
    assertDoesNotThrow(() -> arrayList.add(15, "Element 15"));
    assertEquals(
        "{Element 0, Element 1, Element 2, Element 3, Element 4, Element 5, Element 6, Element 7, Element 8, Element 9, Element 10, Element 11, Element 12, Element 13, Element 14, Element 15}",
        arrayList.toString());
  }

  //Passed
  @Test void add_Bounds2_17Elements()
  {
    for (int i = 0; i < 16; i++)
      arrayList.add(i, "Element " + i);
    assertDoesNotThrow(() -> arrayList.add(16, "Element 16"));
    assertEquals(
        "{Element 0, Element 1, Element 2, Element 3, Element 4, Element 5, Element 6, Element 7, Element 8, Element 9, Element 10, Element 11, Element 12, Element 13, Element 14, Element 15, Element 16}",
        arrayList.toString());
  }

  /*
  3. add(T element)
  Z1 - add element in empty ArrayList
  Z2 - all null element in empty ArrayList
  O - add element in an ArrayList with 1 element
  M1 - add 3 elements in ArrayList with 2 elements
  M2 - add 3 null elements in ArrayList with 2 elements
  B - tested in Zero
  E - none
   */

  //The ArrayList contains the new element - Passed
  @Test void add_Zero1_EmptyArrayList()
  {
    assertDoesNotThrow(() -> arrayList.add("Element"));
    assertEquals("{Element}", arrayList.toString());
  }

  //The ArrayList contains the null element - Passed
  @Test void add_Zero2_NullElement_EmptyArrayList()
  {
    assertDoesNotThrow(() -> arrayList.add(null));
    assertEquals("{null}", arrayList.toString());
  }

  //The ArrayList contains the new element - Passed
  @Test void add_One_OneElementArrayList()
  {
    arrayList.add("a");
    assertDoesNotThrow(() -> arrayList.add("b"));
    assertEquals("{a, b}", arrayList.toString());
  }

  //The ArrayList contains the new elements - Passed
  @Test void add_Many1_ThreeElements_TwoElementsArrayList()
  {
    arrayList.add("a");
    arrayList.add("b");
    assertDoesNotThrow(() -> arrayList.add("c"));
    assertDoesNotThrow(() -> arrayList.add("d"));
    assertDoesNotThrow(() -> arrayList.add("e"));
    assertEquals("{a, b, c, d, e}", arrayList.toString());
  }

  //The ArrayList contains all the added elements - Passed
  @Test void add_Many2_ThreeNullElements_TwoElementsArrayList()
  {
    arrayList.add("a");
    arrayList.add("b");
    assertDoesNotThrow(() -> arrayList.add(null));
    assertDoesNotThrow(() -> arrayList.add(null));
    assertDoesNotThrow(() -> arrayList.add(null));
    assertEquals("{a, b, null, null, null}", arrayList.toString());
  }

  /*
  4. contains(T element)
  Z1 - element searched in empty ArrayList - expect false
  Z2 - null element searched in empty ArrayList - expect false
  O - element searched in ArrayList with 1 element
  M1 - element "B" searched in ArrayList with "A", "B" and "C" elements, - expect true
  M2 - element "B" searched in ArrayList with "A", "C", "D" elements - expect false
  M3 - null element searched in ArrayList with "A", null, "B", null, "C" elements - expect true
  M4 - null element searched in ArrayList with "A", "B", "C" elements - expect false
  B - tested in Zero
  E - none
   */

  //Passed
  @Test void contains_Zero1_EmptyArrayList()
  {
    boolean result = assertDoesNotThrow(() -> arrayList.contains("Element"));
    assertFalse(result);
  }

  //Passed
  @Test void contains_Zero2_NullElement_EmptyArrayList()
  {
    boolean result = assertDoesNotThrow(() -> arrayList.contains(null));
    assertFalse(result);
  }

  //Passed
  @Test void contains_One_OneElementArrayList()
  {
    arrayList.add("Element");
    boolean result = assertDoesNotThrow(() -> arrayList.contains("Element"));
    assertTrue(result);
  }

  //Passed
  @Test void contains_Many1_ThreeElementsArrayList_Found()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    boolean result = assertDoesNotThrow(() -> arrayList.contains("B"));
    assertTrue(result);
  }

  //Passed
  @Test void contains_Many2_ThreeElementsArrayList_NotFound()
  {
    arrayList.add("A");
    arrayList.add("C");
    arrayList.add("D");
    boolean result = assertDoesNotThrow(() -> arrayList.contains("B"));
    assertFalse(result);
  }

  //Passed
  @Test void contains_Many3_NullElement_FiveElementsArrayList_Found()
  {
    arrayList.add("A");
    arrayList.add(null);
    arrayList.add("B");
    arrayList.add(null);
    arrayList.add("C");
    boolean result = assertDoesNotThrow(() -> arrayList.contains(null));
    assertTrue(result);
  }

  //Unexpected exception thrown: java.lang.NullPointerException: Cannot invoke "Object.equals(Object)" because "element" is null
  //The equals() method is probably checking if the object is null and throws an exception
  //Failed
  @Test void contains_Many4_NullElement_ThreeElementsArrayList_NotFound()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    boolean result = assertDoesNotThrow(() -> arrayList.contains(null));
    assertFalse(result);
  }

  /*
  5. get(int index)
  Z1 - get element at index 0 in empty ArrayList - expect exception
  Z2 - get element at index 0 in ArrayList with 3 elements
  O - get element at index 1 in ArrayList with 3 elements
  M1 - get element at index 3 in ArrayList with 5 elements
  M2 - get null element at index 3 in ArrayList with 5 elements //TODO
  B1 - get element at index -1 - expect exception
  B2 - get element at index 3 in ArrayList with 2 elements
  B3 - get element at index 3 in ArrayList with 1 element - expect exception
  E - tested in Zero and Bounds
   */

  //TODO: change type of thrown exception to IndexOutOfBoundsException
  //Unexpected exception type thrown ==> expected: <java.lang.IndexOutOfBoundsException> but was: <java.lang.IllegalStateException>
  //Failed
  @Test void getZeroIndexElementFromEmpty()
  {
    //Z1 - get element at index 0 in empty ArrayList - expect exception
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));
  }

  //Passed
  @Test void getZeroIndexElementFromFilled()
  {
    //Z2 - get element at index 0 in ArrayList with 3 elements
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    assertEquals("a", arrayList.get(0));
  }

  //Passed
  @Test void getFirstIndexElementFromFilledWithThree()
  {
    //O - get element at index 1 in ArrayList with 3 elements
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    assertEquals("b", arrayList.get(1));
  }

  //Passed
  @Test void getFirstIndexElementFromFilledWithFive()
  {
    //M - get element at index 3 in ArrayList with 5 elements
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    arrayList.add("d");
    arrayList.add("e");
    assertEquals("d", arrayList.get(3));
  }

  //Unexpected exception type thrown ==> expected: <java.lang.IndexOutOfBoundsException> but was: <java.lang.IllegalStateException>
  //Failed
  @Test void getMinusIndexElement()
  {
    //B1 - get element at index -1 - expect exception
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
  }

  //Unexpected exception type thrown ==> expected: <java.lang.IndexOutOfBoundsException> but was: <java.lang.IllegalStateException>
  //Failed
  @Test void getElementOutOfBounds()
  {
    //B2 - get element at index 3 in ArrayList with 2 elements
    arrayList.add("a");
    arrayList.add("b");
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(3));
  }

  //Unexpected exception type thrown ==> expected: <java.lang.IndexOutOfBoundsException> but was: <java.lang.IllegalStateException>
  //Failed
  @Test void getElementOutOfBoundsV2()
  {
    //B3 - get element at index 3 in ArrayList with 1 element - expect exception

    arrayList.add("a");
    arrayList.add("b");
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(4));
  }

  /*
  6. indexOf(T element)
  Z - index of element in empty ArrayList - expect -1
  O - index of element in ArrayList with 1 element - expect found
  M1 - index of element in ArrayList with 3 elements - expect found
  M2 - index of element in ArrayList with 3 elements - expect not found
  M3 - index of element "A" in ArrayList with "A", "B", "A", "C" elements - to return the first occurrence//TODO
  M4 - index of element null in ArrayList with "A", null, "A", "C" elements //TODO
  B - tested in Zero
  E - none
   */
  //TODO: none
  //Passed
  @Test void indexOfElementInEmpty()
  {
    //Z - index of element in empty ArrayList - expect -1
    assertEquals(-1, arrayList.indexOf("a"));
  }

  //Passed
  @Test void indexOfElementInFilledWithOne()
  {
    //O - index of element in ArrayList with 1 element - expect found
    arrayList.add("a");
    assertEquals(0, arrayList.indexOf("a"));
  }

  //Passed
  @Test void indexOfElementInFilledWithThree()
  {
    //M1 - index of element in ArrayList with 3 elements - expect found
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    assertEquals(1, arrayList.indexOf("b"));
  }

  //Passed
  @Test void indexOfElementInFilledWithThreeOutOfBound()
  {
    //M2 - index of element in ArrayList with 3 elements - expect not found
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    assertEquals(-1, arrayList.indexOf("d"));
  }

  /*
  7. isEmpty()
  Z - check for empty ArrayList - expect true
  O - check for ArrayList with 1 element - expect false
  M - check for ArrayList with 3 elements - expect false
  B - tested in Zero
  E - none
   */

  //Passed
  @Test void isEmpty_Zero_EmptyArrayList()
  {
    boolean result = assertDoesNotThrow(() -> arrayList.isEmpty());
    assertTrue(result);
  }

  //Passed
  @Test void isEmpty_One_OneElementArrayList()
  {
    arrayList.add("Element");
    boolean result = assertDoesNotThrow(() -> arrayList.isEmpty());
    assertFalse(result);
  }

  //Passed
  @Test void isEmpty_Many_ThreeElementsArrayList()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("D");
    boolean result = assertDoesNotThrow(() -> arrayList.isEmpty());
    assertFalse(result);
  }

 /*
  8. isFull()
  Z - check for an empty ArrayList - expect false
  O - check for an ArrayList with 1 element - expect false
  M - check for an ArrayList with 16 elements - expect false
  B - not possible because array list implementation is unbounded -> no limit on max elements
  E - none
   */

  // Z
  // Passed
  @Test void isFull_empty_arraylist_returns_false()
  {
    assertEquals(false, arrayList.isFull());
  }

  // O
  // Passed
  @Test void isFull_arraylist_with_one_element_returns_false()
  {
    arrayList.add("test");
    boolean result = arrayList.isFull();
    assertEquals(false, result);
  }

  // M
  // Passed
  @Test void isFull_arraylist_with_many_elements_returns_false()
  {
    for (int i = 0; i <= 15; i++)
    {
      arrayList.add("Test " + i);
    }
    boolean result = arrayList.isFull();
    assertEquals(false, result);
  }

  //TODO TODO TODO TODO TODO TODOOOOOOOO: Also use toString() to make sure that the right element was removed for all tests
  /*
  9. remove(int index)
  Z1 - remove element at index 0 in an empty ArrayList - expect exception
  Z2 - remove element at index 0 in an ArrayList with 3 elements //TODO
  O - remove element at index 1 in an ArrayList with 3 elements
  M - remove 3 elements with 5 elements
  B1 - remove element at index -1 - expect exception
  B2 - remove element at index 2 in ArrayList with 3 elements - expect pass
  B3 - remove element at index 2 in ArrayList with 2 elements - expect exception
  E - tested in Zero and Bounds
   */

  //Z1
  // Passed
  @Test void remove_index_0_when_arraylist_empty_throws_exception()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(0));
  }

  // O
  // Passed
  @Test void remove_index_0_when_arraylist_contains_3_elements_expect_2_elements_remaining()
  {
    arrayList.add("test1");
    arrayList.add("test2");
    arrayList.add("test3");
    arrayList.remove(1);
    assertEquals(2, arrayList.size());
  }

  // M
  // Passed
  @Test void remove_3_elements_when_arraylist_contains_5_elements_expect_2_elements_remaining()
  {
    for (int i = 0; i <= 4; i++)
    {
      arrayList.add("Test " + i);
    }
    arrayList.remove(0);
    arrayList.remove(0);
    arrayList.remove(0);
    assertEquals(2, arrayList.size());
  }

  // B1
  //Passed
  @Test void remove_element_index_minus_1_expect_outofbounds_exception()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(-1));
  }

  // B2
  //Passed
  @Test void remove_element_index_2_arraylist_contains_3_elements_passes()
  {
    for (int i = 0; i <= 2; i++)
    {
      arrayList.add("Test " + i);
    }
    assertDoesNotThrow(() -> arrayList.remove(2));
  }

  // B3
  // Passed
  @Test void remove_element_index_3_arraylist_contains_3_elements_throws_outofbounds_exception()
  {
    for (int i = 0; i <= 2; i++)
    {
      arrayList.add("Test " + i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(3));
  }

  /*
  10. remove(T element)
  Z1 - remove element in an empty ArrayList - expect exception
  Z2 - remove null element from empty ArrayList //TODO
  O - remove element in an ArrayList with 1 element
  M1 - remove 2 elements in an ArrayList with 3 elements
  M2 - remove element null from ArrayList with "A", null, "B", null, "C" - remove all occurrences //TODO: Also use toString() to check that both nulls are removed
  B - remove element that in not in the ArrayList - expect exception
  E - tested in Zero and Bounds
    */

  //  Passed
  @Test void remove_From_Empty_ArrayList()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(0));
  }

  //  Passed
  @Test void remove_From_Not_Empty_ArrayList()
  {
    arrayList.add("A");
    String result = assertDoesNotThrow(() -> arrayList.remove("A"));
    assertEquals("A", result);
  }

  //  Passed
  @Test void remove_Many_From_Not_Empty_ArrayList()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");

    String result1 = assertDoesNotThrow(() -> arrayList.remove("A"));
    String result2 = assertDoesNotThrow(() -> arrayList.remove("B"));

    assertEquals("A", result1);
    assertEquals("B", result2);

    assertEquals(1, arrayList.size());
    assertFalse(arrayList.contains("A"));
    assertFalse(arrayList.contains("B"));
  }

  //  Passed
  @Test void remove_Element_Not_Contained_In_ArrayList()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");

    assertThrows(IllegalStateException.class, () -> arrayList.remove("D"));
  }

  /*
    11. set(int index, T element)
    Z1 - set element at index 0 in empty ArrayList - expect exception
    Z2 - set element at index 0 in ArrayList with 3 elements
    O - set element at index 1
    M1 - set 3 elements in ArrayList with 4 elements
    M2 - set null element in ArrayList with 4 elements //TODO
    B1 - set element at index -1 - expect exception
    B2 - set element at index 2 in ArrayList with 3 elements
    B3 - set element at index 2 in ArrayList with 2 elements - expect exception
    E - tested in Zero and Bounds
   */

  //  Passed
  @Test void set_Element_In_EmptyArray()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(0, "A"));
  }

  //  Passed
  @Test void set_Element_In_Not_EmptyArray()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");

    assertDoesNotThrow(() -> arrayList.set(0, "D"));
    assertEquals(3, arrayList.size());
    assertEquals("{D, B, C}", arrayList.toString());

  }

  //  Passed
  @Test void set_Element_At_Index_One()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");

    assertDoesNotThrow(() -> arrayList.set(1, "D"));
    assertEquals(3, arrayList.size());
    assertEquals("{A, D, C}", arrayList.toString());
  }

  //  Passed
  @Test void set_Three_Elements()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    arrayList.add("D");

    assertDoesNotThrow(() -> arrayList.set(0, "X"));
    assertDoesNotThrow(() -> arrayList.set(2, "Y"));
    assertDoesNotThrow(() -> arrayList.set(3, "Z"));
    assertEquals(4, arrayList.size());
    assertEquals("{X, B, Y, Z}", arrayList.toString());
  }

  @Test void set_Null_Element_InFull_Array(){
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    arrayList.add("D");

    assertDoesNotThrow(() -> arrayList.set(0, null));
    assertEquals(4, arrayList.size());
    assertEquals("{null, B, C, D}", arrayList.toString());
  }

  //  Passed
  @Test void set_At_Negative_Index()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(-1, "A"));
  }

  //  Passed
  @Test void set_Last_Element()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");

    assertDoesNotThrow(() -> arrayList.set(2, "D"));
    assertEquals(3, arrayList.size());
    assertEquals("{A, B, D}", arrayList.toString());
  }

  //  Passed
  @Test void set_Last_Out_Of_Bounds()
  {
    arrayList.add("A");
    arrayList.add("B");
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(3, "D"));
  }

  /*
  13. toString()
  Z - check for empty ArrayList - expect "{}"
  O - check for ArrayList with 1 element - expect "{element}"
  M - check for ArrayList with 3 elements - expect "{element1, element2, element3}"
  B - tested in Zero
  E - none
   */

  //Passed
  @Test void toString_Zero_EmptyArrayList()
  {
    String result = assertDoesNotThrow(() -> arrayList.toString());
    assertEquals("{}", result);
  }

  //Passed
  @Test void toString_One_OneElementArrayList()
  {
    arrayList.add("Element");
    String result = assertDoesNotThrow(() -> arrayList.toString());
    assertEquals("{Element}", result);
  }

  //Passed
  @Test void toString_Many_ThreeElementsArrayList()
  {
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    String result = assertDoesNotThrow(() -> arrayList.toString());
    assertEquals("{a, b, c}", result);
  }


 /*
//TODO: Left for Mathias
12. size()
Z - check size for empty ArrayList - expect 0
O1 - check size for ArrayList with 1 element - expect 1
O2 - check size for ArrayList with 1 null element - expect 1
M - check size for ArrayList with 3 elements - expect 3
B1 - check size for ArrayList with 16 elements - expect 16
B2 - check size for ArrayList with 17 elements - expect 17
E - none

  14.
 public T remove(int index)
 {
   //Test case: index<0
   //Test case: index>size-1
   //Test case: index>=0 and index<=size-1
   if (index < 0 || index > size -1)
   {
     throw new IndexOutOfBoundsException("index:" + index);
   }
   T result = list[index];

   //Test case: index=0 and size=1
   //Test case: index=0 and size>1
   //Test case: index=1 and size>index
   for (int i = index; i < size -1; i++)
   {
     list[i] = list[i + 1];
   }
   size--;
   return result;
 }
*/

}