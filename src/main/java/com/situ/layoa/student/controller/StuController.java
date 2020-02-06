package com.situ.layoa.student.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.situ.layoa.student.domain.Student;

@RestController
@RequestMapping("/student")
public class StuController implements Serializable {
	private static final long serialVersionUID = 1L;

	@PostMapping
	public Long doAddAddress(Student student) {
		System.out.println(student);
		return 1L;
	}

	@GetMapping("/checkname")
	public Integer checkname(Student student) {
		System.out.println(student);
		if (student.getStuName().equals("张三")) {
			return 0;
		}
		return 1;
	}
}
