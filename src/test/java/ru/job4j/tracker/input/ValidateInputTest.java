package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutPut;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutPut();
        Input in = new MockInput(
            new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenSuccesfulCorrectOneNumberInput() {
        Output output = new StubOutPut();
        Input in = new MockInput(
          new String[]{"0"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(0);
    }

    @Test
    void whenSuccesfulCorrectAnotherNumberInput() {
        Output output = new StubOutPut();
        Input in = new MockInput(
            new String[]{"0", "1", "2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(0);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(1);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(2);
    }

    @Test
    void whenSuccesfulIncorrectOneNumberNegativeInput() {
        Output output = new StubOutPut();
        Input in = new MockInput(
            new String[]{"-4"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-4);
    }
}