package com.nerdemo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

@Path("/classify")
public class ClassifierRestResource {
    
    @Inject
    private CRFClassifier<CoreLabel> classifier;

    @GET
    @Path("/{text}")
    public List<Result> findNer(@PathParam("text") String text){
        List<List<CoreLabel>> classify = classifier.classify(text);
        List<Result> results = new ArrayList<>();
        for (List<CoreLabel> coreLabels : classify) {
            for (CoreLabel coreLabel : coreLabels) {
                String word = coreLabel.word();
                String answer = coreLabel.getString(CoreAnnotations.AnswerAnnotation.class);
                results.add(new Result(word, answer));
            }
        }
        return results;
    }
}
