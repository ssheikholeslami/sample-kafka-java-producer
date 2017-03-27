import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * Created by sinash on 3/26/17.
 */
public class SampleProducer {

    public Properties kafkaProps;
    public KafkaProducer producer;

    public SampleProducer() {

        kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "broker1:9092,broker2:9092");

        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("key.value", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<String, String>(kafkaProps);

    }

    public void fireAndForget(String topic, String key, String value) {

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendSynchronous(String topic, String key, String value) {

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
        try {
            RecordMetadata metaData = (RecordMetadata) producer.send(record).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendAsynchronous(String topic, String key, String value){
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
        try {
            producer.send(record, new ProducerCallBack());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
