package com.example.kiranaapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
	private static final String FILE_PATH = "G:\\Kirana-Assest\\rohan.csv";

	@GetMapping("/students")
	public List<Student> getStudentDetails(@RequestParam(defaultValue = "1") Integer page,

			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(required = false) String nameFilter,
			@RequestParam(required = false) Integer ageFilter

	) throws IOException {
		List<Student> studentDetails = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				int id = Integer.parseInt(values[0]);
				String name = values[1];
				int age = Integer.parseInt(values[2]);
				int totalMarks = Integer.parseInt(values[3]);
				Student student = new Student(id, name, age, totalMarks);
				studentDetails.add(student);
			}
		}

		if (page != null) {
			studentDetails.removeIf(student -> student.getId() != page);
		}

		if (nameFilter != null) {
			studentDetails.removeIf(student -> !student.getName().contains(nameFilter));
		}
		if (ageFilter != null) {
			studentDetails.removeIf(student -> student.getAge() != ageFilter);
		}
		if (pageSize != null) {
			studentDetails.removeIf(student -> student.getTotalMarks() != pageSize);
		}

		int startIndex = (page - 1) * pageSize;
		int endIndex = Math.min(startIndex + pageSize, studentDetails.size());

		return studentDetails.subList(startIndex, endIndex);
	}
}
