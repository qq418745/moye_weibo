package top.moyeye.service.fw;

public interface FwService<T> {

   void processor(Processor<T> processor);

}
