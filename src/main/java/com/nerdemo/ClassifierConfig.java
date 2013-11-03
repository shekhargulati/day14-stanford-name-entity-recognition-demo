package com.nerdemo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

public class ClassifierConfig {

    private String serializedClassifier = "classifiers/english.all.3class.distsim.crf.ser.gz";

    @Produces
    @Named
    @ApplicationScoped
    public CRFClassifier<CoreLabel> classifier(){
        CRFClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
        return classifier;
    }
}
