package de.vill.model;

import de.vill.config.Configuration;
import de.vill.util.Util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FeatureModel {
    private Feature rootFeature;
    private String namespace;

    private List<Import> imports = new LinkedList<>();

    private List<Constraint> constraints = new LinkedList<>();

    private Map<String, Feature> featureMap = new HashMap<>();

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public Map<String, Feature> getFeatureMap() {
        return featureMap;
    }

    public Feature getRootFeature() {
        return rootFeature;
    }

    public void setRootFeature(Feature rootFeature) {
        this.rootFeature = rootFeature;
    }
    public String getNamespace() {
        return namespace;
    }
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    public List<Import> getImports() {
        return imports;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        if(namespace != null) {
            result.append("namespace ");
            result.append(namespace);
            result.append(Configuration.NEWLINE);
            result.append(Configuration.NEWLINE);
        }
        if(imports.size() > 0){
            result.append("imports");
            result.append(Configuration.NEWLINE);
            for(Import importLine : imports){
                result.append(Configuration.TABULATOR);
                result.append(importLine.getNamespace());
                if(importLine.getAlias() != null){
                    result.append(" as ");
                    result.append(importLine.getAlias());
                }
                result.append(Configuration.NEWLINE);
            }
            result.append(Configuration.NEWLINE);
        }
        if(rootFeature != null) {
            result.append("features");
            result.append(Configuration.NEWLINE);
            result.append(Util.indentEachLine(getRootFeature().toString()));
            result.append(Configuration.NEWLINE);
        }
        if(getConstraints().size() > 0) {
            result.append("constraints");
            result.append(Configuration.NEWLINE);
            for(Constraint constraint : constraints){
                result.append(Configuration.TABULATOR);
                result.append(constraint.toString());
                result.append(Configuration.NEWLINE);
            }
        }
        return result.toString();
    }
}
