package me.surendra.tdd;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StateMethodMachine {

    final State state = new State();

    @Test
    public void shouldReturnReadyForStart() {
        assertThat(state.getState("start"), equalTo("ready"));
    }

    @Test
    public void shouldReturnRIfInputNextAfterReady() {
        assertThat(state.getState("next"), equalTo("R"));
//        Assert.assertThat(state.getState("next"), Matchers.equalTo("R"));
    }

    @Test
    public void shouldReturnReadyIfInputIsDone() {
        assertThat(state.getState("done"), equalTo("ready"));
    }

    @Test
    public void shouldReturnGIfInputIs() {
        assertThat(state.getState("next"), equalTo("G"));
    }

    @Test
    public void shouldReturnStates() {
        final StateMethod stateMethod = new StateMethod();
        assertThat(stateMethod.getStart(), equalTo("ready"));
        assertThat(stateMethod.getStart(), equalTo("ready"));
        assertThat(stateMethod.getNext(), equalTo("R"));
        assertThat(stateMethod.getNext(), equalTo("R"));
        assertThat(stateMethod.getDone(), equalTo("ready"));
        assertThat(stateMethod.getNext(), equalTo("G"));
        assertThat(stateMethod.getStart(), equalTo("ready"));
        assertThat(stateMethod.getNext(), equalTo("G"));
        assertThat(stateMethod.getDone(), equalTo("ready"));
        assertThat(stateMethod.getNext(), equalTo("B"));
        assertThat(stateMethod.getNext(), equalTo("B"));
        assertThat(stateMethod.getDone(), equalTo("ready"));
        assertThat(stateMethod.getNext(), equalTo("R"));
    }


}

class StateMethod {
    int counter = 0;
    final private Map<Integer, String> rgbMap = Maps.newHashMap();

    StateMethod() {
        rgbMap.put(0, "R");
        rgbMap.put(1, "G");
        rgbMap.put(2, "B");
    }

    String getStart() {
//        counter = 0;
        return "ready";
    }

    String getNext() {
        String s = rgbMap.get(counter % 3);
        System.out.println(counter + "," + s);
        return s;
    }

    String getDone() {
        counter++;
        return "ready";
    }

}


class State {
    final private Map<Integer, String> rgbMap = Maps.newHashMap();
    final private Map<String, String> stateMap = Maps.newHashMap();
    private int counter = -1;

    State() {
        rgbMap.put(0, "R");
        rgbMap.put(1, "G");
        rgbMap.put(2, "B");

        stateMap.put("start", "ready");
        stateMap.put("next", rgbMap.get(counter%3));
        stateMap.put("done", "ready");
    }

    private String incrementAndGetState() {
        counter++;
        System.out.println("incrementAndGetState counter=["+counter+"]");
        return "ready";
    }

    String getState(final String input) {
        System.out.println("incrementAndGetState counter=["+counter+"] input=["+input+"]");

        return stateMap.getOrDefault(input, "invalid");
    }
}
