package com.nerdemo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

@ApplicationScoped
public class ClassifierConfig {

    private String serializedClassifier = "classifiers/english.all.3class.distsim.crf.ser.gz";
    private CRFClassifier<CoreLabel> classifier;

    @PostConstruct
    public void postConstruct() {
        CRFClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
        this.classifier = classifier;
    }

    @Produces
    @Named
    public CRFClassifier<CoreLabel> classifier() {
        return classifier;
    }
}
