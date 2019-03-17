package com.huda.unittesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateParkLotTest.class, ParkCommandTest.class, LeaveCommandTest.class, RegistrationNumberByColorCommandTestTest.class, SlotNumberByColorRegistrationNumberTest.class, SlotNumberForCarsByColorTest.class })
public class AllTests {

}
