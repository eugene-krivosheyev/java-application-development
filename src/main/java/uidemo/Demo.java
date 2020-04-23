package uidemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo {

}


class MyForm {
    private TransControll service;
    private Button button;
    private InputField input;

    void init(Service service) {
        button.addListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.disable();

                service.transaction(....)

            }
        });
    }
}