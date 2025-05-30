package sudoku.sudokugame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class SudokuGameBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(SudokuGameBackEndApplication.class, args);
	}

}
