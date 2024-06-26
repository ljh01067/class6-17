package org.ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    @Test
    @DisplayName("1 + 1 = 2")
    void t1(){
        assertThat(org.ex.Calc.run("1 + 1")).isEqualTo(2);
    }
    @Test
    @DisplayName("2 + 1 = 3")
    void t2(){
        assertThat(org.ex.Calc.run("2 + 1")).isEqualTo(3);
    }
    @Test
    @DisplayName("2 + 2 = 3")
    void t3(){
        assertThat(org.ex.Calc.run("2 + 2")).isEqualTo(4);
    }
    @Test
    @DisplayName("1000 + 200 = 1200")
    void t4(){
        assertThat(org.ex.Calc.run("1000 + 200")).isEqualTo(1200);
    }
    @Test
    @DisplayName("50 - 30 = 20")
    void t5(){
        assertThat(org.ex.Calc.run("50 - 30")).isEqualTo(20);
    }
    @Test
    @DisplayName("10 + 20 + 30 = 60")
    void t6(){
        assertThat(org.ex.Calc.run("10 + 20 + 30")).isEqualTo(60);
    }
    @Test
    @DisplayName("10 - 20 + 30 = 20")
    void t7(){
        assertThat(org.ex.Calc.run("10 - 20 + 30")).isEqualTo(20);
    }
    @Test
    @DisplayName("10 - 10 - 10 - 10 + 10 + 10 - 10 = -10")
    void t8(){
        assertThat(org.ex.Calc.run("10 - 10 - 10 - 10 + 10 + 10 - 10")).isEqualTo(-10);
    }
    @Test
    @DisplayName("10 * 10 * 10 = 1000")
    void t9(){
        assertThat(org.ex.Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }
    @Test
    @DisplayName("10 + 5 * 2 = 20")
    void t10(){
        assertThat(org.ex.Calc.run("10 + 5 * 2")).isEqualTo(20);
    }
    @Test
    @DisplayName("20 + 10 + 5 * 2 = 40")
    void t11(){
        assertThat(org.ex.Calc.run("20 + 10 + 5 * 2")).isEqualTo(40);
    }
    @Test
    @DisplayName("20 + 10 * 5 + 10 = 80")
    void t12(){
        assertThat(org.ex.Calc.run("20 + 10 * 5 + 10")).isEqualTo(80);
    }
    @Test
    @DisplayName("10 * 20 + 10 * 5 = 250")
    void t13(){
        assertThat(org.ex.Calc.run("10 * 20 + 10 * 5")).isEqualTo(250);
    }
    @Test
    @DisplayName("(20 + 20) + 20 = 60")
    void t14(){
        assertThat(org.ex.Calc.run("(20 + 20) + 20")).isEqualTo(60);
    }
    @Test
    @DisplayName("(10 + 20) * 3 = 90")
    void t15(){
        assertThat(org.ex.Calc.run("(10 + 20) * 3")).isEqualTo(90);
    }
    @Test
    @DisplayName("10 + (10 + 5) = 25")
    void t16(){
        assertThat(org.ex.Calc.run("10 + (10 + 5)")).isEqualTo(25);
    }
    @Test
    @DisplayName("-(10 + 5) = -15")
    void t17(){
        assertThat(org.ex.Calc.run("-(10 + 5)")).isEqualTo(-15);
    }
    @Test
    @DisplayName("-(8 + 2) * -(7 + 3) + 5 = 105")
    void t18(){
        assertThat(org.ex.Calc.run("-(8 + 2) * -(7 + 3) + 5")).isEqualTo(105);
    }
    @Test
    @DisplayName("((20 + 20)) + 20 = 60")
    void t19(){
        assertThat(org.ex.Calc.run("((20 + 20)) + 20")).isEqualTo(60);
    }
    @Test
    @DisplayName("(((20 + 20))) + 20 = 60")
    void t20(){
        assertThat(org.ex.Calc.run("(((20 + 20))) + 20")).isEqualTo(60);
    }
}
