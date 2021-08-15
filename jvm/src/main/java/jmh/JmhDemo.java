package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author sunjianrong
 * @date 2021/8/14 上午9:48
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
public class JmhDemo {

    public static final int TOTAL = 100000;


    @Benchmark
    public void stringTest() {
        String string = "";
        for (int i = 0; i < TOTAL; i++) {
            string = string + i;
        }
//        System.out.println(string);
    }

    @Benchmark
    public void stringBuilderTest() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TOTAL; i++) {
            sb.append(i);
        }
//        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws RunnerException {
        Options build = new OptionsBuilder().include(JmhDemo.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(build).run();

    }
}
