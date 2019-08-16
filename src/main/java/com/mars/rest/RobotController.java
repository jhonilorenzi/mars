package com.mars.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mars.controller.Movements;
import com.mars.controller.RobotControl;
import com.mars.model.Ground;
import com.mars.model.OutOfAreaException;
import com.mars.model.Position;

@RestController
public class RobotController {

	@RequestMapping(value= "rest/mars/{commands}", method = RequestMethod.POST)
    public ResponseEntity getRobot(@PathVariable("commands") String commands) {
		try {
			RobotControl robotControl = new RobotControl(parseMovements(commands), new Position(0, 0), new Ground(5, 5));
			String s = robotControl.executeMovements();
	        return new ResponseEntity(s, HttpStatus.OK);
		} catch (IllegalArgumentException | OutOfAreaException e) {
			return ResponseEntity.badRequest().build();
		}
    }

	private Movements[] parseMovements(String movements) {
		List<Movements> parsedMovements = new ArrayList<>();
		for (char movement : movements.toCharArray()) {
			switch (movement) {
			case 'M':
				parsedMovements.add(Movements.FORWARD);
				break;
			case 'R':
				parsedMovements.add(Movements.RIGHT);
				break;
			case 'L':
				parsedMovements.add(Movements.LEFT);
				break;
			default:
				throw new IllegalArgumentException();
			}
		}

		return parsedMovements.toArray(new Movements[parsedMovements.size()]);
	}
}
	