package cn.faury.fwmf.module.service;

import java.util.Arrays;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        List<String> orderStates = Arrays.asList("1", "2", "3");
        String states = orderStates.stream()
                .reduce("(", (connectState, state) -> {
                    return connectState + "#{" + state + "},";
                });
        System.out.println(states);
    }
}
