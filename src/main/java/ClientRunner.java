/**
 * Created by sinash on 3/27/17.
 */
public class ClientRunner {


    public static void main(String[] args) {

        if (args[0] == "--sample") {
            SampleProducer producer = new SampleProducer();
            while (true) {
                producer.fireAndForget("test-sample", "key", "value");
            }
        } else if (args[0] == "--avro") {
            while (true) {

                //Avro producer initiation here


            }
        }


    }
}