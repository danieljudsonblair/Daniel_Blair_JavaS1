package com.example.U1M4SummativeBlairDaniel.controller;

import com.example.U1M4SummativeBlairDaniel.model.Answer;
import com.example.U1M4SummativeBlairDaniel.model.Definition;
import com.example.U1M4SummativeBlairDaniel.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class U1M4SummativeBlairDanielController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {
        Quote quote = new Quote();
        Random rand = new Random();

        int num = rand.nextInt((9) + 1) + 1;

        switch (num) {
            case 1:
                quote.setAuthor("Tom Cruise");
                quote.setQuote("I am dangerous.");
                return quote;
            case 2:
                quote.setAuthor("Eugene Robinson");
                quote.setQuote("Run the length of the football field; stiff-arm a man in dey mowf.");
                return quote;
            case 3:
                quote.setAuthor("George Washington");
                quote.setQuote("I cannot tell a lie.");
                return quote;
            case 4:
                quote.setAuthor("Darth Vader");
                quote.setQuote("No, I am your Father.");
                return quote;
            case 5:
                quote.setAuthor("Maury Povich");
                quote.setQuote("You are not the father.");
                return quote;
            case 6:
                quote.setAuthor("Daniel Blair");
                quote.setQuote("My name is Dan.  People call me Dan.");
                return quote;
            case 7:
                quote.setAuthor("Trilogy Curriculum");
                quote.setQuote("Your service must contain at least 10 quotes.");
                return quote;
            case 8:
                quote.setAuthor("Matt Foley");
                quote.setQuote("I live in a van down by the river.");
                return quote;
            case 9:
                quote.setAuthor("Neil Armstrong");
                quote.setQuote("That's one small step for man, one giant leap for mankind.");
                return quote;
            case 10:
                quote.setAuthor("Scott Manley");
                quote.setQuote("I'm Scott Manley.  Fly Safe.");
                return quote;
            default:
                return null;
        }
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getDefinition() {
        Definition definition = new Definition();
        Random rand = new Random();

        int num = rand.nextInt((9) + 1) + 1;

        switch (num) {
            case 1:
                definition.setWord("brochette");
                definition.setDefinition("skewer for holding food steady while cooking");
                return definition;
            case 2:
                definition.setWord("urdee");
                definition.setDefinition("of a heraldic device, pointed or broken into parallel pointed projections");
                return definition;
            case 3:
                definition.setWord("stillatim");
                definition.setDefinition("drop by drop");
                return definition;
            case 4:
                definition.setWord("umbiliciform");
                definition.setDefinition("shaped like a navel");
                return definition;
            case 5:
                definition.setWord("croche");
                definition.setDefinition("knob at the top of a deer's horn");
                return definition;
            case 6:
                definition.setWord("subfocal");
                definition.setDefinition("of which one is only dimly aware");
                return definition;
            case 7:
                definition.setWord("landau");
                definition.setDefinition("horse-drawn carriage with folding top");
                return definition;
            case 8:
                definition.setWord("onymous");
                definition.setDefinition("bearing the author's name");
                return definition;
            case 9:
                definition.setWord("hula");
                definition.setDefinition("sinuous Polynesian dance with rhythmic hip movements");
                return definition;
            case 10:
                definition.setWord("bisulcate");
                definition.setDefinition("cloven-footed; cleft in two");
                return definition;
            default:
                return null;
        }
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer postQuestion(@RequestBody Answer answerIn) {
        Answer answer = new Answer();
        Random rand = new Random();

        answer.setQuestion(answerIn.getQuestion());
        int num = rand.nextInt((5) + 1) + 1;

        switch (num) {
            case 1:
                answer.setAnswer("It is certain");
                return answer;
            case 2:
                answer.setAnswer("Yes");
                return answer;
            case 3:
                answer.setAnswer("Ask again later");
                return answer;
            case 4:
                answer.setAnswer("Don't count on it");
                return answer;
            case 5:
                answer.setAnswer("Very doubtful");
                return answer;
            case 6:
                answer.setAnswer("Reply hazy, try again");
                return answer;
            default:
                return null;
        }
    }
}
