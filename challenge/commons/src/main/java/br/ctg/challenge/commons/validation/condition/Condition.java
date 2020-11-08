package br.ctg.challenge.commons.validation.condition;

public interface Condition<S> {

    Boolean conditionTriggered(S validable);
}
