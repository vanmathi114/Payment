package Online.Shopping.Platform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducerService {
    private static final String TOPIC = "BuyNotification";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendPurchaseNotification(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
