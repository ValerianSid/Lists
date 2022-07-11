package lists.services;

import lists.Button;

public interface IOService {
    String read();
    void write(String message);

    Button readbutton();

}
