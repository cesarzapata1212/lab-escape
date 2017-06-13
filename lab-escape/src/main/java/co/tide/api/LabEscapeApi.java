package co.tide.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static co.tide.escape.LabEscape.drawPathForEscape;

/**
 * Created by czapata on 6/12/17.
 */

@RestController
public class LabEscapeApi {

    @RequestMapping(value = "/draw-escape", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MazeResult> drawEscape(@RequestBody MazeSearchRequest req) {

        try {
            char[][] result = drawPathForEscape(req.getMatrix(), req.getStartX(), req.getStartY());
            return new ResponseEntity<>(new MazeResult(result), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MazeResult(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
