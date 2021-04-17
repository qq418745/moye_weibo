package top.moyeye.service.fw;

public interface Processor<T> {
    T process() throws Exception;
}
