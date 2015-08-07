package edu.umt.jsf.beans;

import edu.umt.db.DatabaseManager;
import edu.umt.db.entities.SourceNames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tb189431e on 7/27/15.
 */
public class SourcesBackingBean extends BaseBackingBean{
    private String[] selectedSources;
    private List<String> sources;

    private void init(){
        if(sources == null)
            sources = new ArrayList<String>();
        Iterator<SourceNames> sourceNamesList = DatabaseManager.getRecords(SourceNames.class).iterator();
        while(sourceNamesList.hasNext()){
            SourceNames sn = sourceNamesList.next();
            sources.add(sn.getName());
        }
    }

    public String[] getSelectedSources() {
        return selectedSources;
    }

    public void setSelectedSources(String[] selectedSources) {
        this.selectedSources = selectedSources;
    }

    public List<String> getSources() {
        if(sources == null || sources.isEmpty())
            init();
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }
}
