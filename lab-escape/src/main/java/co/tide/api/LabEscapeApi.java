package co.tide.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by czapata on 6/12/17.
 */

@RestController
public class LabEscapeApi {

    @RequestMapping(value = "/draw-escape", method = RequestMethod.POST)
    public char[][] drawEscape(@RequestBody char[][] matrix){

        return new char[0][0];
    }

}
