package Logger;

import ProducerConsumer.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoggerTest
{
  private Logger sut;

  @BeforeEach void setUp()
  {
    sut = Logger.getInstance();
  }

  /*
  1. addLog
  White box testing
*/
  @Test
  void loggerNullOutputsBlank()
  {
    sut.addLog(null);
  }

  @Test
  void loggerEmptyOutputsEmpty() {
    sut.addLog("");
  }

  @Test
  void loggerStringOutputsString() {
    sut.addLog("Test");
  }
}