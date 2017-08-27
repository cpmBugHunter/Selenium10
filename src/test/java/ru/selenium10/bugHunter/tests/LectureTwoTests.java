package ru.selenium10.bugHunter.tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class LectureTwoTests extends TestBase {

    @Test
    public void testLoginAsAdmin_CorrectData_Success() throws IOException {
        appMngr.goTo().page("/admin");
        appMngr.admin().logout();
        appMngr.admin().login("admin", "admin");
    }
}
