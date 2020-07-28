package kiz.learnwithvel.yelinc.util;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kiz.learnwithvel.yelinc.util.Utilities.Field;

import static kiz.learnwithvel.yelinc.Utilities.CONFIRM_PASSWORD;
import static kiz.learnwithvel.yelinc.Utilities.INVALID_EMAIL;
import static kiz.learnwithvel.yelinc.Utilities.INVALID_NO_DOMAIN;
import static kiz.learnwithvel.yelinc.Utilities.INVALID_PASSWORD;
import static kiz.learnwithvel.yelinc.Utilities.VALID_EMAIL;
import static kiz.learnwithvel.yelinc.Utilities.VALID_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class UtilitiesTest {

    @Mock
    private UtilityFieldTest util;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void areFieldEmpty_withEmail_returnFalse() {
        // Arrange
        when(util.areFieldEmpty(anyString(), anyString(), anyString())).thenReturn(false);
        // Act
        boolean returnedValue = util.areFieldEmpty(VALID_EMAIL, "", "");
        verify(util).areFieldEmpty(anyString(), anyString(), anyString());
        verifyNoMoreInteractions(util);

        // Assert
        assertFalse(returnedValue);
    }

    @Test
    void areFieldEmpty_withEmailPassword_returnFalse() {
        // Arrange
        when(util.areFieldEmpty(anyString(), anyString(), anyString())).thenReturn(false);
        // Act
        boolean returnedValue = util.areFieldEmpty(VALID_EMAIL, VALID_PASSWORD, "");
        verify(util).areFieldEmpty(anyString(), anyString(), anyString());
        verifyNoMoreInteractions(util);

        // Assert
        assertFalse(returnedValue);
    }

    @Test
    void areFieldEmpty_withEmailPasswordConfirm_returnFalse() {
        // Arrange
        when(util.areFieldEmpty(anyString(), anyString(), anyString())).thenReturn(true);
        // Act
        boolean returnedValue = util.areFieldEmpty(VALID_EMAIL, VALID_PASSWORD, CONFIRM_PASSWORD);
        verify(util).areFieldEmpty(anyString(), anyString(), anyString());
        verifyNoMoreInteractions(util);

        // Assert
        assertTrue(returnedValue);
    }


    @Test
    void isValid_invalidEmail_returnFalse() {
        // Arrange
        when(util.isValid(INVALID_EMAIL)).thenReturn(false);
        // Act
        boolean returnedValue = util.isValid(INVALID_EMAIL);
        verify(util).isValid(INVALID_EMAIL);
        verifyNoMoreInteractions(util);

        // Assert
        assertFalse(returnedValue);
    }

    @Test
    void isValid_validEmail_returnTrue() {
        // Arrange
        when(util.isValid(VALID_EMAIL)).thenReturn(true);
        // Act
        boolean returnedValue = util.isValid(VALID_EMAIL);
        verify(util).isValid(VALID_EMAIL);
        verifyNoMoreInteractions(util);

        // Assert
        assertTrue(returnedValue);
    }


    @Test
    void isValid_noDomain_returnTrue() {
        // Arrange
        when(util.isValid(INVALID_NO_DOMAIN)).thenReturn(false);
        // Act
        boolean returnedValue = util.isValid(INVALID_NO_DOMAIN);
        verify(util).isValid(INVALID_NO_DOMAIN);
        verifyNoMoreInteractions(util);

        // Assert
        assertFalse(returnedValue);
    }

    @Test
    void isMatch_returnFalse() {
        // Arrange
        when(util.isMatch(VALID_PASSWORD, INVALID_PASSWORD)).thenReturn(false);
        // Act
        boolean returnedValue = util.isMatch(VALID_PASSWORD, INVALID_PASSWORD);
        verify(util).isMatch(VALID_PASSWORD, INVALID_PASSWORD);
        verifyNoMoreInteractions(util);

        // Assert
        assertFalse(returnedValue);
    }

    @Test
    void isMatch_returnTrue() {
        // Arrange
        when(util.isMatch(VALID_PASSWORD, VALID_PASSWORD)).thenReturn(true);
        // Act
        boolean returnedValue = util.isMatch(VALID_PASSWORD, VALID_PASSWORD);
        verify(util).isMatch(VALID_PASSWORD, VALID_PASSWORD);
        verifyNoMoreInteractions(util);

        // Assert
        assertTrue(returnedValue);
    }
}

class UtilityFieldTest {

    public boolean areFieldEmpty(String email, String password, String confirm) {
        return areFieldEmpty(email, password, confirm);
    }

    public boolean isValid(String email) {
        return Field.isValid(email);
    }

    public boolean isMatch(String password, String confirm) {
        return Field.isMatch(password, confirm);
    }
}
