package top.moyeye.service.fw;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.moyeye.exception.FwException;


@Service
@Transactional(readOnly = true)
public class FwServiceImpl implements FwService {

    @Override
    @Transactional
    public void processor(Processor processor) {
        try {
            processor.process();
        } catch (Exception e) {
            throw new FwException("", e);
        }
    }


}
