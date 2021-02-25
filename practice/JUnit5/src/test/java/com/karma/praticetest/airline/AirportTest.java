package com.karma.praticetest.airline;

import com.karma.practice.airline.*;
import org.junit.jupiter.api.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Economy Flight Test Cases")
    @Nested
    class EconomicClassTest {
        private Flight economyFlight;
        private Passenger kung;
        private Passenger lee;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            kung = new Passenger("Kung", false);
            lee = new Passenger("lee", true);


        }

        @Nested
        @DisplayName("When we have usual Passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can add remove from an economy Flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("Asserting all the condition for the usual passenger " +
                                "and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(kung)),
                        () -> assertEquals(1, economyFlight.getPassengerList().size()),
                        () -> assertTrue( economyFlight.getPassengerList().contains(kung)),
                        () -> assertEquals(true, economyFlight.removePassenger(kung)),
                        () -> assertEquals(0, economyFlight.getPassengerList().size())
                );
            }
            @Test
            @DisplayName("Then you cannot same passenger more than once in economy Flight")
            @RepeatedTest(5)
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition() ; i++) {
                    economyFlight.addPassenger(kung);
                }
                assertAll("verify the usual passenger can be added " +
                        "to economy flight once ",
                        ()->assertEquals(1,economyFlight.getPassengerList().size()),
                        ()->assertTrue(economyFlight.getPassengerList().contains(kung))
                );
            }
        }

        @Nested
        @DisplayName("When we have VIP Passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add  from an economy Flight")
            public void testEconomyFlightVipPassenger() {
                assertAll("Asserting all the condition for the VIP passenger " +
                                "and an economy flight",
                        () ->assertEquals("1", economyFlight.getId()),
                        () ->assertEquals(true, economyFlight.addPassenger(lee)),
                        () ->assertEquals(1, economyFlight.getPassengerList().size()),
                        () ->assertTrue(economyFlight.getPassengerList().contains(lee)),
                        () ->assertEquals(false, economyFlight.removePassenger(lee)),
                        () ->assertEquals(1, economyFlight.getPassengerList().size()));
            }
        }


    }


    @DisplayName("Business Flight Test Cases")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger kung;
        private Passenger lee;
        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            kung = new Passenger("Kung", false);
            lee = new Passenger("lee", true);
        }
        @Nested
        @DisplayName("When we have usual Passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then then you cannot add them in Business Flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll("Asserting all the condition for the usual passenger " +
                "and an business flight",
                        ()-> assertEquals("2", businessFlight.getId()),
                        ()-> assertEquals(false, businessFlight.addPassenger(kung)),
                        ()->assertEquals(0, businessFlight.getPassengerList().size()),
                        ()-> assertEquals(false, businessFlight.removePassenger(kung))
                        );
            }
        }

        @Nested
        @DisplayName("When we have VIP Passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add from an Business Flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Asserting all the condition for the VIP passenger " +
                                "and an business flight",
                        ()->assertEquals("2", businessFlight.getId()),
                        ()->assertEquals(true, businessFlight.addPassenger(lee)),
                        ()->assertEquals(1, businessFlight.getPassengerList().size()),
                        ()->assertTrue( businessFlight.getPassengerList().contains(lee)),
                        ()->assertEquals(false, businessFlight.removePassenger(lee)),
                        ()->assertEquals(1, businessFlight.getPassengerList().size()));
            }
        }



    }
    @Nested
    @DisplayName("Premium Flight Test Cases")
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger kung;
        private Passenger lee;
        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            kung = new Passenger("Kung", false);
            lee = new Passenger("lee", true);
        }
        @Nested
        @DisplayName("When we have usual Passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then then you cannot add them in Premium Flight")
            public void testPremiumFlightUsualPassenger() {
                assertAll("Asserting all the condition for the usual passenger " +
                                "and an Premium flight",
                        ()-> assertEquals("3", premiumFlight.getId()),
                        ()-> assertEquals(false, premiumFlight.addPassenger(kung)),
                        ()->assertEquals(0, premiumFlight.getPassengerList().size()),
                        ()-> assertEquals(false, premiumFlight.removePassenger(kung))
                );
            }
        }

        @Nested
        @DisplayName("When we have VIP Passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add from an Premium Flight")
            public void testPremiumFlightVipPassenger() {
                assertAll("Asserting all the condition for the VIP passenger " +
                                "and an Premium flight",
                        ()->assertEquals("3", premiumFlight.getId()),
                        ()->assertEquals(true, premiumFlight.addPassenger(lee)),
                        ()->assertEquals(1, premiumFlight.getPassengerList().size()),
                        ()->assertTrue( premiumFlight.getPassengerList().contains(lee)),
                        ()->assertEquals(true, premiumFlight.removePassenger(lee)),
                        ()->assertEquals(0, premiumFlight.getPassengerList().size()));
            }
        }
    }

}
