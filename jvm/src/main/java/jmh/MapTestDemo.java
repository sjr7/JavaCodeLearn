package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author sunjianrong
 * @date 2021/8/14 上午10:13
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Threads(5)
@State(Scope.Benchmark)
public class MapTestDemo {

    private Map<Long, Long> concurrentMap;
    private Map<Long, Long> synchronizedMap;

    @Setup
    public void setUp() {
        concurrentMap = new ConcurrentHashMap<>();
        synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    }

    @Benchmark
    public void testConcurrentMap() {
        this.concurrentMap.put(System.nanoTime(), System.nanoTime());
    }


    @Benchmark
    public void testSynchronizedMap() {
        this.synchronizedMap.put(System.nanoTime(), System.nanoTime());
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(MapTestDemo.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
