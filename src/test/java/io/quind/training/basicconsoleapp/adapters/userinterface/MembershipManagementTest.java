package io.quind.training.basicconsoleapp.adapters.userinterface;

import io.quind.training.basicconsoleapp.domain.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MembershipManagementTest {
    private static MembershipManagement mm;
    private static Scanner mockedReader;

    @BeforeAll
    static void setUP() {
        mockedReader = mock(Scanner.class);
        mm = new MembershipManagement(mockedReader);
    }

    @DisplayName("Should insert correct integer value")
    @ParameterizedTest(name = "{index} => Input Value = {0}")
    @ValueSource(ints = {1, 2, 3, -1})
    void getChoice(int in) {
        int expected = in;
        when(mockedReader.nextInt()).thenReturn(in);
        int result = mm.getChoice();
        assertEquals(expected, result);
        String resultAdd = mm.addMembers(buildList());
        assertEquals(expected,result);

    }

    private LinkedList<Member> buildList() {
        LinkedList<Member> list = new LinkedList<>();
        return list;
    }

}