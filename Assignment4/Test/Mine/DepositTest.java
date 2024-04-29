package Mine;

import ProducerConsumer.Deposit;
import ProducerConsumer.Valuable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest
{
  private Deposit sut;

  @BeforeEach void setUp() {
    sut = new Deposit(3);

    Valuable diamond = Valuable.getInstance("diamond");
    Valuable goldenNugget = Valuable.getInstance("golden nugget");
    Valuable jewel = Valuable.getInstance("jewel");

    sut.depositValuable(diamond);
    sut.depositValuable(goldenNugget);
    sut.depositValuable(jewel);
  }

  @Test
  void extract_Valuable_Once_Returns_Valuable() {
    Valuable extractedValuable = sut.extractValuable();

    assertEquals("jewel", extractedValuable.getName());
  }

  @Test
  void extractValuable_Many_Returns_Correct_Valuables() {
    Valuable firstExtractedValuable = sut.extractValuable();
    Valuable secondExtractedValuable = sut.extractValuable();

    assertEquals("jewel", firstExtractedValuable.getName());
    assertEquals("golden nugget", secondExtractedValuable.getName());
  }
}