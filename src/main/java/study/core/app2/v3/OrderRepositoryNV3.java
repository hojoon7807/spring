package study.core.app2.v3;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryNV3 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw  new IllegalStateException("예외 발생");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
