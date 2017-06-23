package ing.gzq;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by gzq on 17-6-23.
 */
public class Console {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Client client = new Client();
        client.login();
        client.askHowMuchCourse();
        client.perpare();
        client.start();
    }


}
