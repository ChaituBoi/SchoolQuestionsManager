package com.project1.QuestionsManager.rest;


import com.project1.QuestionsManager.Data.Question;
import com.project1.QuestionsManager.Data.QuestionRepository;
import com.project1.QuestionsManager.Exceptions.QuestionNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Qapi/questions")
public class QuestionRestController {


    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/")
    public List<Question> getAllQuestions() {
        List<Question> questionList = questionRepository.findAll();

        if(questionList.size()==0)
        {
            throw new QuestionNotFound("Question list is currently empty. Kindly wait till more questions get added.");
        }
        return questionList;
    }

    @GetMapping("/{question_id}")
    public Question getAllQuestions(@PathVariable int question_id) {
        Optional<Question> question = questionRepository.findById(question_id);

        if(question.isPresent())
        {
            return question.get();
        }
        else
        {
            throw new QuestionNotFound("Question with id: "+ question_id +" doesn't exist.");
        }
    }


    @GetMapping("/difficulty/{difficulty}")
    public List<Question> getQuestionsWithDiff(@PathVariable String difficulty) {
        List<Question> questionList = questionRepository.findAllByDifficulty(difficulty);

        if(questionList.size()==0)
        {
            if(difficulty != "EASY" && difficulty != "MEDIUM" && difficulty != "HARD") {
                System.out.println("-"+difficulty+"-");
                throw new QuestionNotFound("Invalid difficulty: " + difficulty + ". Valid values - EASY, MEDIUM, HARD.");
            }
            else
                throw new QuestionNotFound("0 questions with difficulty: "+ difficulty +".");
        }
        else
        {
            return questionList;
        }
    }

    @PostMapping("/")
    @Transactional
    public Question saveQuestion(@RequestBody Question question) {

        Question updatedQ = questionRepository.save(question);
        return updatedQ;

    }

    @DeleteMapping("/{question_id}")
    @Transactional
    public void deleteQuestion(@PathVariable int question_id) {

        Optional<Question> toDelete = questionRepository.findById(question_id);

        if(toDelete.isPresent())
        {
            questionRepository.delete(toDelete.get());
        }
        else
        {
            throw new QuestionNotFound("Question with id: " + question_id + " doesn't exist.");
        }

    }



}
