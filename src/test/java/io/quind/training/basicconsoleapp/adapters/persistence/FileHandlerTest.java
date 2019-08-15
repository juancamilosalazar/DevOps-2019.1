package io.quind.training.basicconsoleapp.adapters.persistence;

import io.quind.training.basicconsoleapp.domain.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


class FileHandlerTest {

    @DisplayName("Should return return correct to string value")
    @ParameterizedTest(name = "{index} => memberID = {0}, memberType = {1}, name = {2}, fees = {3} ")
    @CsvSource({
            "1, S, Name1, 100",
            "2, M, Name2, 300",
            "3, M, Name3, 200"
    })
    void testToString(int memberID, char memberType, String name, double fees) {
        FileHandler fileHandler= new FileHandler();
        fileHandler.appendFile(new Member(5,'1',"sdads",234523.0D));
        fileHandler.overwriteFile(buildList());
    }


    private LinkedList<Member> buildList() {
        LinkedList<Member> list = new LinkedList<>();
        Member member1 = new Member(5,'1',"sdads",234523.0D);
        Member member2 = new Member(5,'1',"sdads",234523.0D);
        list.add(member1);
        list.add(member2);
        return list;
    }
}