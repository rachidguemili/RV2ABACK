package com.BackApiTest.BackApiTest.chat.discussion;

import com.BackApiTest.BackApiTest.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class DiscussionController {

	@Autowired
	DiscussionService discussionService;

	@GetMapping
	public  List<Discussion> getAll(){
		return  discussionService.getAll();
	}
	@GetMapping("/discussions/{id}")
	public List<Discussion> getAllByPatientId(@PathVariable Long id)
	{
		return discussionService.getAllByPatientId(id);
	}

	@PostMapping("/{id}")
	public  Discussion addDiscussion(@PathVariable Long id, @RequestBody Discussion discussion)
	{
		if (discussion.getPatient().getId()== null) return null;

		Patient patient = discussion.getPatient();
		patient.getDiscussion().add(discussion);

		return discussionService.save(discussion);
	}
}
