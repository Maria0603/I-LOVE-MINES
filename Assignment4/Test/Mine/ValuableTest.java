package Mine;

import ProducerConsumer.Valuable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValuableTest
{
  private Valuable valuable;

  @Test
  void valuable_Get_Instance_Name_Diamond_Returns_Valuable_With_Name_Diamond() {
    Valuable sut = Valuable.getInstance("diamond");

    assertEquals(sut.getName(), "diamond");
  }

  @Test
  void valuable_Get_Instance_Name_Golden_Nugget_Returns_Valuable_With_Name_Golden_Nugget() {
    Valuable sut = Valuable.getInstance("golden nugget");

    assertEquals(sut.getName(),"golden nugget");
  }

  @Test
  void valuable_Get_Instance_Name_Jewel_Returns_Valuable_With_Name_Jewel() {
    Valuable sut = Valuable.getInstance("jewel");

    assertEquals(sut.getName(), "jewel");
  }

  @Test
  void valuable_Get_Instance_Name_Ruby_Returns_Valuable_With_Name_Ruby() {
    Valuable sut = Valuable.getInstance("ruby");

    assertEquals(sut.getName(),"ruby");
  }

  @Test
  void valuable_Get_Instance_Name_Wooden_Coin_Returns_Valuable_With_Name_Wooden_Coin()
  {
    Valuable sut = Valuable.getInstance("wooden coin");

    assertEquals(sut.getName(), "wooden coin");
  }

  @Test
  void valuable_Get_Instance_Random_Name_Returns_Null() {
    Valuable sut = Valuable.getInstance("other");

    assertNull(sut);
  }

  @Test
  void valuable_ToString_Returns_String_With_Name_And_Value() {
    Valuable sut = Valuable.getInstance("diamond");

    // sut.getName() + " ($" + sut.getValue() + ")"
    // "Diamond $78"
    assertEquals(sut.getName() + " ($" + sut.getValue() + ")", sut.toString());
  }
}