package practicegrammer;

import java.util.Queue;

public class StreamPracticeFunc {
    final private Queue<String> p;
    private String value;
    private static StreamPracticeFunc func;
    private StreamPracticeFunc(Queue<String> p, String value){
        this.p = p;
    }
    public static StreamPracticeFunc defaultFunc(Queue<String> p, String value){
        func = (func == null) ?
                new StreamPracticeFunc(p, value) :
                func;
        func.value = value;
        return func;
    }
    public boolean filterTest(){
        return p.peek().equals(value);
    }
    public void print(){
        p.poll();
        p.poll();
        System.out.println(value);
    }
}
