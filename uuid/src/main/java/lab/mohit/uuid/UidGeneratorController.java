package lab.mohit.uuid;

import lab.mohit.uuid.impl.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UidGeneratorController {
    @Autowired
    UidGenerator uidGenerator;

    @GetMapping("/getUuid")
    public String getUuid() {
        return Long.toString(uidGenerator.getUid());
    }

}
