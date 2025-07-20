package testingDates;

import static org.junit.Assert.*;

import org.junit.Test;
import buildToTestLab.Date;

public class DateAddDaysTest {

    @Test
    public void testAddOneDaySameMonthMiddle() {
        Date date = new Date("January", 15, 2023);
        date.addOneDay();
        Date expected = new Date("January", 16, 2023);
        assertEquals("Adding one day in middle of January should increment day", expected, date);
    }
  
    @Test
    public void testAddOneDaySameMonthStart() {
        Date date = new Date("March", 1, 2024);
        date.addOneDay();
        Date expected = new Date("March", 2, 2024);
        assertEquals("Adding one day at start of March should increment day", expected, date);
    }

    @Test
    public void testAddOneDayCrossMonthJanuary() {
        Date date = new Date("January", 31, 2023);
        date.addOneDay();
        Date expected = new Date("February", 1, 2023);
        assertEquals("Adding one day on January 31 should move to February 1", expected, date);
    }

    @Test
    public void testAddOneDayCrossMonthApril() {
        Date date = new Date("April", 30, 2024);
        date.addOneDay();
        Date expected = new Date("May", 1, 2024);
        assertEquals("Adding one day on April 30 should move to May 1", expected, date);
    }

    @Test
    public void testAddOneDayCrossMonthSeptember() {
        Date date = new Date("September", 30, 2025);
        date.addOneDay();
        Date expected = new Date("October", 1, 2025);
        assertEquals("Adding one day on September 30 should move to October 1", expected, date);
    }

    @Test
    public void testAddOneDayCrossYear() {
        Date date = new Date("December", 31, 2023);
        date.addOneDay();
        Date expected = new Date("January", 1, 2024);
        assertEquals("Adding one day on December 31 should move to January 1 of next year", expected, date);
    }

    @Test
    public void testSetDateIllegalDayZero() {
        Date date = new Date(2, 28, 2024);
        Date original = new Date(2, 28, 2024);
        date.setDate("February", 0, 2024);
        assertEquals("Setting day to 0 should not change date", original, date);
    }

    @Test
    public void testSetDateIllegalDayTooHigh() {
        Date date = new Date(9, 15, 2025);
        Date original = new Date(9, 15, 2025);
        date.setDate("September", 32, 2025);
        assertEquals("Setting day to 32 should not change date", original, date);
    }

    @Test
    public void testSetDateIllegalYearTooLow() {
        Date date = new Date(5, 20, 2023);
        Date original = new Date(5, 20, 2023);
        date.setDate("May", 20, 999);
        assertEquals("Setting year to 999 should not change date", original, date);
    }

    @Test
    public void testSetDateIllegalYearTooHigh() {
        Date date = new Date(11, 10, 2024);
        Date original = new Date(11, 10, 2024);
        date.setDate("November", 10, 10000);
        assertEquals("Setting year to 10000 should not change date", original, date);
    }
}